package br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.mapper.impl;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.dto.request.MercadoPagoOrderItemRequest;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.dto.request.MercadoPagoOrderRequest;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.mapper.MercadoPagoOrderRequestMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class MercadoPagoOrderRequestMapperImpl implements MercadoPagoOrderRequestMapper {

    @Override
    public MercadoPagoOrderRequest pedidoParaMercadoPagoOrderItemRequest(Pedido pedido) {

        List<MercadoPagoOrderItemRequest> mercadoPagoOrderItemRequests = new ArrayList<>();

        pedido.getProdutos().forEach(produto -> {
            BigDecimal totalPrecoItem = produto.getProduto().getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade()));
            MercadoPagoOrderItemRequest mercadoPagoOrderItemRequest = MercadoPagoOrderItemRequest.builder()
                    .skuNumber(produto.getProduto().getId())
                    .category(produto.getProduto().getCategoria().getNome())
                    .title(produto.getProduto().getNome())
                    .description(produto.getProduto().getDescricao())
                    .quantity(produto.getQuantidade())
                    .unitPrice(produto.getProduto().getPreco())
                    .unitMeasure("unit")
                    .totalAmount(totalPrecoItem)
                    .build();
            mercadoPagoOrderItemRequests.add(mercadoPagoOrderItemRequest);
        });

        return MercadoPagoOrderRequest.builder()
//                .externalReference(pedido.getId())
                .externalReference("Fatura-0001")
                .title(pedido.getCodigo())
                .description(pedido.getObservacao())
                .notificationUrl("https://webhook.site/bebb631d-f42e-4dbd-a12e-8f041db03514")
                .totalAmount(pedido.getPreco())
                .items(mercadoPagoOrderItemRequests)
                .build();
    }
}