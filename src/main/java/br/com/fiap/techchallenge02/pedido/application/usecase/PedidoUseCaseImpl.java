package br.com.fiap.techchallenge02.pedido.application.usecase;

import br.com.fiap.techchallenge02.pedido.adapter.gateway.PedidoGateway;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCaseImpl(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums) {
        return pedidoGateway.buscarPedidos(statusPedidoEnums);
    }
}
