package br.com.fiap.techchallenge02.pedido.application.usecase;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public interface ConsultarPedidoUseCase {

    List<Pedido> buscarPedidos(List<StatusPedidoEnum> status);
}
