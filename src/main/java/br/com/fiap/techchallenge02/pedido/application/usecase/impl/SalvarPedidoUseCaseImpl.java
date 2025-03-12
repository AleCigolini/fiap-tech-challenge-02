package br.com.fiap.techchallenge02.pedido.application.usecase.impl;

import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.dto.request.MercadoPagoOrderRequest;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.MercadoPagoCodigoQRClient;
import br.com.fiap.techchallenge02.pedido.application.gateway.PedidoGateway;
import br.com.fiap.techchallenge02.pedido.application.usecase.SalvarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.ProdutoPedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.mapper.MercadoPagoOrderRequestMapper;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class SalvarPedidoUseCaseImpl implements SalvarPedidoUseCase {

    private final PedidoGateway pedidoOutputPort;
    private final ProdutoUseCase produtoUseCase;
    private final MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient;
    private final MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper;

    @Autowired
    public SalvarPedidoUseCaseImpl(PedidoGateway pedidoOutputPort,
                                   ProdutoUseCase produtoUseCase,
                                   MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient,
                                   MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper) {
        this.pedidoOutputPort = pedidoOutputPort;
        this.produtoUseCase = produtoUseCase;
        this.mercadoPagoCodigoQRClient = mercadoPagoCodigoQRClient;
        this.mercadoPagoOrderRequestMapper = mercadoPagoOrderRequestMapper;
    }


    @Value("#{new Long('${client.mercado-pago.user_id}')}")
    private Long userId;
    @Value("${client.mercado-pago.external_store_id}")
    private String externalStoreId;
    @Value("${client.mercado-pago.external_pos_id}")
    private String externalPosId;
    @Value("${client.mercado-pago.auth_header}")
    private String authHeader;

    @Override
    public Pedido criarPedido(Pedido pedido) {
//        return pedidoOutputPort.criarPedido(pedido);
        //TODO: COLOCAR O CLIENTE
        montarPedido(pedido);

//        Pedido pedidoCriado = pedidoOutputPort.criarPedido(pedido);

        //TODO: ENVIAR PAGAMENTO
        enviarPagamento(pedido);

        return pedido;
    }

    @Override
    public void atualizarStatus() {
//        // TODO: ALTERAR O STATUS DO PEDIDO PARA APROVADO OU REJEITADO
//        //  VER OUTROS STATUS DE PAGAMENTO PRA CONSIDERAR 3 TENTATIVAS POR EXEMPLO
//        try {
//            // O Mercado Pago envia um ID de pagamento que você pode usar para consultar a transação.
//            // Vamos simular que o ID da transação está na notificação como exemplo.
//            String paymentId = extractPaymentIdFromNotification(notificacao);
//            System.out.println("Notificacao: " + notificacao);
//            // Consultar o status do pagamento
////            Payment payment = Payment.findById(paymentId);
////            Payment payment = new Payment();
//            // Processar o pagamento dependendo do status
////            if (payment.getStatus().equals("approved")) {
////                logger.info("Pagamento aprovado: " + payment.getId());
////                // Realizar ação como atualizar status no banco de dados, enviar e-mail, etc.
////            } else if (payment.getStatus().equals("rejected")) {
////                logger.warn("Pagamento rejeitado: " + payment.getId());
////                // Realizar ação de erro ou alerta
////            } else {
////                logger.info("Pagamento com status: " + payment.getStatus());
////            }
//        } catch (Exception e) {
////            logger.error("Erro ao processar a notificação: " + e.getMessage());
//            System.out.println("ERRO: " + e.getMessage());
//        }
//    }
//
//    // Metodo para extrair o ID do pagamento da notificação recebida
//    private String extractPaymentIdFromNotification(WebhookNotificationDTO notification) {
//        // Aqui você deve fazer o parse do JSON e extrair o ID do pagamento
//        // Isso pode variar dependendo da estrutura exata do webhook
//        return notification.getData().getId(); // Retornar apenas o ID como exemplo
//    }
    }

    public void montarPedido(Pedido pedido) {
        List<ProdutoPedido> produtos = new ArrayList<>();
        ProdutoPedido produtoPedido;
        var precoTotal = new BigDecimal(BigInteger.ZERO);

        for (ProdutoPedido produtoPedidoAux : pedido.getProdutos()) {
            Produto produto = produtoUseCase.buscarProdutoPorId(produtoPedidoAux.getProduto().getId());

            precoTotal = precoTotal.add(produto.getPreco().multiply(BigDecimal.valueOf(produtoPedidoAux.getQuantidade())));

            produtoPedido = new ProdutoPedido();
            produtoPedido.setProduto(produto);
            produtoPedido.setQuantidade(produtoPedidoAux.getQuantidade());
            produtoPedido.setObservacao(produtoPedidoAux.getObservacao());
            produtos.add(produtoPedido);
        }
        pedido.setProdutos(produtos);
        pedido.setCodigo(gerarCodigo());
        pedido.setStatus(StatusPedidoEnum.ABERTO.toString());
        pedido.setPreco(precoTotal);
    }


    // TODO: MOVER PARA NOVO MÓDULO PAGAMENTO
    private void enviarPagamento(Pedido pedido) {

        MercadoPagoOrderRequest mercadoPagoOrderRequest = mercadoPagoOrderRequestMapper.pedidoParaMercadoPagoOrderItemRequest(pedido);

        try {
            Object response = mercadoPagoCodigoQRClient.pedidosPresenciaisV2(
                    userId,
                    externalStoreId,
                    externalPosId,
                    authHeader,
                    mercadoPagoOrderRequest);
            System.out.println(response);
        } catch (Exception ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s",
                    ex.getCause(), ex.getMessage());
        }
//        pedido.setStatus(StatusPedido.RECEBIDO.toString());
//        pedido.setCodigoPagamento(pagamentoEfetuado.getId());
//        pedido.setDataAtualizacao(OffsetDateTime.now());
//        pedidoRepository.atualizarStatusPedido(pedido);
    }

    private String gerarCodigo() {
        var CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        var TAMANHO_CODIGO = 5;

        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < TAMANHO_CODIGO; i++) {
            int indice = random.nextInt(CARACTERES.length());
            codigo.append(CARACTERES.charAt(indice));
        }
        return codigo.toString();
    }
}