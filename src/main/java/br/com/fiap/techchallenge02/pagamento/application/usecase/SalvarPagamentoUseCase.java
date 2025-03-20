package br.com.fiap.techchallenge02.pagamento.application.usecase;

import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;

public interface SalvarPagamentoUseCase {

    Pagamento criarPagamentoPendenteParaOPedido(Pedido pedido, boolean criouPedidoMercadoPago);

    Pagamento salvarPagamento(Pagamento pagamento);
}
