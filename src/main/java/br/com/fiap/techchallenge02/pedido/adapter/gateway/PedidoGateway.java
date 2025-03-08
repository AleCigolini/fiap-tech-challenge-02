package br.com.fiap.techchallenge02.pedido.adapter.gateway;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public interface PedidoGateway {

    List<Pedido> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums);
}
