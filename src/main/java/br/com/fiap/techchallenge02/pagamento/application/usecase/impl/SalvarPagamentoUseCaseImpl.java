package br.com.fiap.techchallenge02.pagamento.application.usecase.impl;

import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.usecase.SalvarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.request.WebhookNotificationRequestDto;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import br.com.fiap.techchallenge02.pagamento.domain.StatusPagamentoEnum;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoCodigoQRClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoPosClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.mapper.MercadoPagoOrderRequestMapper;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.request.MercadoPagoOrderRequest;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.response.MercadoPagoPosResponse;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

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
    private final MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient;
    private final MercadoPagoPosClient mercadoPagoPosClient;
    private final MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper;

    @Autowired
    public SalvarPagamentoUseCaseImpl(PagamentoGateway pagamentoOutputPort,
                                      MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient,
                                      MercadoPagoPosClient mercadoPagoPosClient,
                                      MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper) {
        this.pagamentoOutputPort = pagamentoOutputPort;
        this.mercadoPagoCodigoQRClient = mercadoPagoCodigoQRClient;
        this.mercadoPagoPosClient = mercadoPagoPosClient;
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

            Object response = mercadoPagoCodigoQRClient.pedidosPresenciaisV2(
                    userId,
                    externalStoreId,
                    externalPosId,
                    authHeader,
                    mercadoPagoOrderRequest);
            // TODO: FAZER VALIDAÇÕES: NULLPOINTER, STATUS_CODE 200 E DIFERENTE DE 200
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
        // TODO: FAZER TENTATIVA DE PAGAMENTO E SALVAR COM STATUS PENDENTE
        //  DEPOIS VIA WEBHOOK O STATUS DO PAGAMENTO E DO PEDIDO DEVEM SER ATUALIZADOS
        //  STATUS_PAGAMENTO: O QUE RETORNAR DO MERCADO PAGO;
        //  STATUS_PEDIDO: SE RETORNAR SUCESSO DO MERCADO PAGO ENTÃO ALTERAR O STATUS DO PEDIDO PARA StatusPedidoEnum.APROVADO("Aprovado")
    }

    @Override
    public BufferedImage gerarImagemCodigoQRCaixa() {
        try {
            ResponseEntity<MercadoPagoPosResponse> response =
                    mercadoPagoPosClient.obterCaixa(
                            posId,
                            authHeader);

            // TODO: FAZER VALIDAÇÕES: NULLPOINTER, STATUS_CODE 200 E DIFERENTE DE 200
            String enderecoImagem = response.getBody().getQr().getImage();
            URL imageURL = new URL(enderecoImagem);
            return ImageIO.read(imageURL);

        } catch (Exception ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s",
                    ex.getCause(), ex.getMessage());
            return null;
        }
    }

//    @Override
//    public void atualizarStatus() {
////        // TODO: ALTERAR O STATUS DO PEDIDO PARA APROVADO OU REJEITADO
////        //  VER OUTROS STATUS DE PAGAMENTO PRA CONSIDERAR 3 TENTATIVAS POR EXEMPLO
////        try {
////            // O Mercado Pago envia um ID de pagamento que você pode usar para consultar a transação.
////            // Vamos simular que o ID da transação está na notificação como exemplo.
////            String paymentId = extractPaymentIdFromNotification(notificacao);
////            System.out.println("Notificacao: " + notificacao);
////            // Consultar o status do pagamento
//////            Payment payment = Payment.findById(paymentId);
//////            Payment payment = new Payment();
////            // Processar o pagamento dependendo do status
//////            if (payment.getStatus().equals("approved")) {
//////                logger.info("Pagamento aprovado: " + payment.getId());
//////                // Realizar ação como atualizar status no banco de dados, enviar e-mail, etc.
//////            } else if (payment.getStatus().equals("rejected")) {
//////                logger.warn("Pagamento rejeitado: " + payment.getId());
//////                // Realizar ação de erro ou alerta
//////            } else {
//////                logger.info("Pagamento com status: " + payment.getStatus());
//////            }
////        } catch (Exception e) {
//////            logger.error("Erro ao processar a notificação: " + e.getMessage());
////            System.out.println("ERRO: " + e.getMessage());
////        }
////    }
////
////    // Metodo para extrair o ID do pagamento da notificação recebida
////    private String extractPaymentIdFromNotification(WebhookNotificationDTO notification) {
////        // Aqui você deve fazer o parse do JSON e extrair o ID do pagamento
////        // Isso pode variar dependendo da estrutura exata do webhook
////        return notification.getData().getId(); // Retornar apenas o ID como exemplo
////    }
//    }
}