package br.com.fiap.techchallenge02.pedido.application.usecase.impl;

import br.com.fiap.techchallenge02.pedido.application.gateway.PedidoGateway;
import br.com.fiap.techchallenge02.pedido.application.usecase.ConsultarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public class ConsultarPedidoUseCaseImpl implements ConsultarPedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public ConsultarPedidoUseCaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums) {
        return pedidoGateway.buscarPedidos(statusPedidoEnums);
    }

    @Override
    public Pedido buscarPedidoPorId(String id) {
        return pedidoGateway.buscarPedidoPorId(id);
    }
}
