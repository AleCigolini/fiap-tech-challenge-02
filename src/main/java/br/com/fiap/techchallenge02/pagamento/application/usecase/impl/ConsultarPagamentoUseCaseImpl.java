package br.com.fiap.techchallenge02.pagamento.application.usecase.impl;

import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.usecase.ConsultarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarPagamentoUseCaseImpl implements ConsultarPagamentoUseCase {

    @Autowired
    private PagamentoGateway pagamentoOutputPort;

    @Override
    public List<Pagamento> buscarPagamentosPorPedidoId(String pedidoId) {
        return pagamentoOutputPort.buscarPagamentosPorPedidoId(pedidoId);
    }
}