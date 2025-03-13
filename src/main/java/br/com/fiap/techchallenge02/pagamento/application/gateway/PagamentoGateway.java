package br.com.fiap.techchallenge02.pagamento.application.gateway;

import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;

import java.util.List;

public interface PagamentoGateway {

    List<Pagamento> buscarPagamentosPorPedidoId(String pedidoId);

    Pagamento salvarPagamento(Pagamento pagamento);
}