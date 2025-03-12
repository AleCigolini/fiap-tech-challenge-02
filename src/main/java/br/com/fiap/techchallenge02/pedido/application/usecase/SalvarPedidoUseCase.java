package br.com.fiap.techchallenge02.pedido.application.usecase;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

public interface SalvarPedidoUseCase {

    Pedido criarPedido(Pedido pedido);

    Pedido atualizarStatusPedido(StatusPedidoEnum statusPedidoEnum, String id);
}
