package br.com.fiap.techchallenge02.pedido.application.mapper;

import br.com.fiap.techchallenge02.pedido.common.domain.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;

import java.util.List;

public interface DatabasePedidoMapper {

    JpaPedidoEntity pedidoParaJpaPedidoEntity(Pedido pedido);

    Pedido jpaPedidoEntityParaPedido(JpaPedidoEntity jpaPedidoEntity);

    List<Pedido> jpaPedidosEntityParaPedidos(List<JpaPedidoEntity> jpaPedidoEntities);
}