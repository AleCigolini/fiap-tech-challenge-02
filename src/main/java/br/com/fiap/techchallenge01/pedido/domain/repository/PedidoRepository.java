package br.com.fiap.techchallenge01.pedido.domain.repository;

import br.com.fiap.techchallenge01.pedido.domain.Pedido;

import java.util.List;

public interface PedidoRepository {

    List<Pedido> buscarPedidos();

    Pedido criarPedido(Pedido pedido);

    Pedido atualizarStatusPedido(Pedido pedido);
}