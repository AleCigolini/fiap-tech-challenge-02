package br.com.fiap.techchallenge02.pedido.application.usecase;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;

public interface SalvarPedidoUseCase {

    Pedido criarPedido(Pedido pedido);

    void atualizarStatus();
}
