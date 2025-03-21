package br.com.fiap.techchallenge02.pagamento.application.usecase;

import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;

import java.util.List;

public interface ConsultarPagamentoUseCase {

    List<Pagamento> buscarPagamentosPorPedidoId(String pedidoId);
}