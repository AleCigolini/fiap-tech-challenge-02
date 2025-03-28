package br.com.fiap.techchallenge02.pagamento.application.usecase.impl;

import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.usecase.ConsultarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;

import java.util.List;

public class ConsultarPagamentoUseCaseImpl implements ConsultarPagamentoUseCase {

    private final PagamentoGateway pagamentoGateway;

    public ConsultarPagamentoUseCaseImpl(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    @Override
    public List<Pagamento> buscarPagamentosPorPedidoId(String pedidoId) {
        return pagamentoGateway.buscarPagamentosPorPedidoId(pedidoId);
    }
}