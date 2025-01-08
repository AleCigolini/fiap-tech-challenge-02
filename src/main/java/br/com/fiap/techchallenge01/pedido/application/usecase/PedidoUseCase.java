package br.com.fiap.techchallenge01.pedido.application.usecase;

import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoStatusRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;

import java.util.List;

public interface PedidoUseCase {

    List<PedidoResponseDTO> buscarPedidos();

    PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO);
}