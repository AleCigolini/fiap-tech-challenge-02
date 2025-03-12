package br.com.fiap.techchallenge02.pedido.application.gateway;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public interface PedidoGateway {

    List<Pedido> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums);

    Pedido buscarPedidoPorId(String id);

    Pedido salvarPedido(Pedido pedido);
}