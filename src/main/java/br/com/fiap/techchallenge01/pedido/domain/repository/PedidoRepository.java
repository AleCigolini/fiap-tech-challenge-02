package br.com.fiap.techchallenge01.pedido.domain.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    List<Pedido> buscarPedidos();

    Pedido criarPedido(Pedido pedido);
}