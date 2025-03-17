package br.com.fiap.techchallenge02.pagamento.application.usecase.impl;

import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.usecase.SalvarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.request.WebhookNotificationRequestDto;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import br.com.fiap.techchallenge02.pagamento.domain.StatusPagamentoEnum;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoCodigoQRClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoMerchantOrdersClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoPosClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.mapper.MercadoPagoOrderRequestMapper;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.request.MercadoPagoOrderRequest;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.response.MercadoPagoMerchantOrderResponse;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.response.MercadoPagoPosResponse;
import br.com.fiap.techchallenge02.pedido.application.usecase.ConsultarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.application.usecase.SalvarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.*;

@Service
@AllArgsConstructor
public class SalvarPagamentoUseCaseImpl implements SalvarPagamentoUseCase {

    @Value("#{new Long('${client.mercado-pago.user_id}')}")
    private Long userId;
    @Value("${client.mercado-pago.pos_id}")
    private String posId;
    @Value("${client.mercado-pago.external_store_id}")
    private String externalStoreId;
    @Value("${client.mercado-pago.external_pos_id}")
    private String externalPosId;
    @Value("${client.mercado-pago.auth_header}")
    private String authHeader;

    private final PagamentoGateway pagamentoOutputPort;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;
    private final SalvarPedidoUseCase salvarPedidoUseCase;
    private final MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient;
    private final MercadoPagoPosClient mercadoPagoPosClient;
    private final MercadoPagoMerchantOrdersClient mercadoPagoMerchantOrdersClient;
    private final MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper;

    @Autowired
    public SalvarPagamentoUseCaseImpl(PagamentoGateway pagamentoOutputPort,
                                      ConsultarPedidoUseCase consultarPedidoUseCase,
                                      @Lazy SalvarPedidoUseCase salvarPedidoUseCase,
                                      MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient,
                                      MercadoPagoPosClient mercadoPagoPosClient,
                                      MercadoPagoMerchantOrdersClient mercadoPagoMerchantOrdersClient,
                                      MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper) {
        this.pagamentoOutputPort = pagamentoOutputPort;
        this.consultarPedidoUseCase = consultarPedidoUseCase;
        this.salvarPedidoUseCase = salvarPedidoUseCase;
        this.mercadoPagoCodigoQRClient = mercadoPagoCodigoQRClient;
        this.mercadoPagoPosClient = mercadoPagoPosClient;
        this.mercadoPagoMerchantOrdersClient = mercadoPagoMerchantOrdersClient;
        this.mercadoPagoOrderRequestMapper = mercadoPagoOrderRequestMapper;
    }

    @Override
    @Transactional
    public Pagamento salvarPagamentoDoPedido(Pedido pedido) {

        boolean sucessoEnvio = enviaPagamentoMercadoPago(pedido);

        Pagamento pagamento = new Pagamento();
        pagamento.setPreco(pedido.getPreco());
        pagamento.setCodigoPedido(pedido.getId());

        pagamento.setStatus(!sucessoEnvio ?
                StatusPagamentoEnum.FALHA.toString() :
                StatusPagamentoEnum.PENDENTE.toString());

        return pagamentoOutputPort.salvarPagamento(pagamento);
    }

    private boolean enviaPagamentoMercadoPago(Pedido pedido) {

        try {
            MercadoPagoOrderRequest mercadoPagoOrderRequest = mercadoPagoOrderRequestMapper.pedidoParaMercadoPagoOrderItemRequest(pedido);

            mercadoPagoCodigoQRClient.pedidosPresenciaisV2(
                    userId,
                    externalStoreId,
                    externalPosId,
                    authHeader,
                    mercadoPagoOrderRequest);
            return true;
        } catch (Exception ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s",
                    ex.getCause(), ex.getMessage());
            return false;
        }
    }

    @Override
    public void processarNotificacao(WebhookNotificationRequestDto notificacao) {

        try {
            ResponseEntity<Object> response =
                    mercadoPagoMerchantOrdersClient.obterPagamento(
                            notificacao.getId(),
                            authHeader);

            if (response.getStatusCode().is2xxSuccessful()) {

                var responseBody = (LinkedHashMap) response.getBody();

                MercadoPagoMerchantOrderResponse orderResponse = new MercadoPagoMerchantOrderResponse();

                for (Object key : responseBody.keySet()) {
                    if (key.equals("status")) {
                        orderResponse.setStatus((String) responseBody.get(key));

                    } else if (key.equals("id")) {
                        orderResponse.setId((Long) responseBody.get(key));

                    } else if (key.equals("external_reference")) {
                        orderResponse.setExternalReference((String) responseBody.get(key));
                    }
                }

                if (orderResponse.getStatus().equals("closed")) {
                    Pedido pedido = consultarPedidoUseCase.buscarPedidoPorId(orderResponse.getExternalReference());

                    Pagamento pagamento = new Pagamento();
                    pagamento.setPreco(pedido.getPreco());
                    pagamento.setCodigoPedido(pedido.getId());
                    pagamento.setStatus(StatusPagamentoEnum.APROVADO.toString());
                    pagamentoOutputPort.salvarPagamento(pagamento);

                    pedido.setStatus(StatusPedidoEnum.RECEBIDO.toString());
                    pedido.setCodigoPagamento(orderResponse.getId().toString());
                    salvarPedidoUseCase.atualizarPedido(pedido);
                }
            }

        } catch (Exception ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s",
                    ex.getCause(), ex.getMessage());
        }
    }

    @Override
    public BufferedImage gerarImagemCodigoQRCaixa() {
        try {
            ResponseEntity<MercadoPagoPosResponse> response =
                    mercadoPagoPosClient.obterCaixa(
                            posId,
                            authHeader);

            if (response.getStatusCode().is2xxSuccessful()) {
                String enderecoImagem = response.getBody().getQr().getImage();
                URL imageURL = new URL(enderecoImagem);
                return ImageIO.read(imageURL);
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s",
                    ex.getCause(), ex.getMessage());
            return null;
        }
    }
}