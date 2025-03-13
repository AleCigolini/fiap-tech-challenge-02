package br.com.fiap.techchallenge02.pedido.common.interfaces;

import br.com.fiap.techchallenge02.pedido.common.domain.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;
import java.util.Optional;

public interface PedidoDatabase {

    List<JpaPedidoEntity> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums);

    JpaPedidoEntity criarPedido(JpaPedidoEntity jpaPedidoEntity);

    JpaPedidoEntity salvarPedido(JpaPedidoEntity jpaPedidoEntity);

    Optional<JpaPedidoEntity> buscarPedidoPorId(String id);
}
