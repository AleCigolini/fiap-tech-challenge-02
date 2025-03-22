package br.com.fiap.techchallenge02.pedido.application.usecase;


import br.com.fiap.techchallenge02.pedido.domain.Pedido;

public interface CriarPedidoMercadoPagoUseCase {

    boolean criarPedidoMercadoPago(Pedido pedido);
}
