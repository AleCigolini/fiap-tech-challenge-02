package br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.mapper;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.request.MercadoPagoOrderRequest;

public interface MercadoPagoOrderRequestMapper {

    MercadoPagoOrderRequest pedidoParaMercadoPagoOrderItemRequest(Pedido pedido);
}