package br.com.fiap.techchallenge02.pedido.common.interfaces;

import br.com.fiap.techchallenge02.pedido.common.domain.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public interface PedidoDatabase {

    List<JpaPedidoEntity> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums);

    JpaPedidoEntity criarPedido(JpaPedidoEntity jpaPedidoEntity);
}
