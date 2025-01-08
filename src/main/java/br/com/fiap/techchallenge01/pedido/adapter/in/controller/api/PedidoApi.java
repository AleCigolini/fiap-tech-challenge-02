package br.com.fiap.techchallenge01.pedido.adapter.in.controller.api;

import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

@Tag(name = "Pedidos")
public interface PedidoApi {

    /**
     * Busca todos os pedidos
     *
     * @return {@link PedidoResponseDTO}
     */
    @Operation(summary = "Buscar todos os pedidos")
    ResponseEntity<List<PedidoResponseDTO>> buscarPedidos();

    /**
     * Criar pedido
     *
     * @param pedidoRequestDTO DTO para criação de pedido
     * @return {@link PedidoResponseDTO}
     */
    @Operation(summary = "Criar novo pedido")
    ResponseEntity<PedidoResponseDTO> criarPedido(PedidoRequestDTO pedidoRequestDTO) throws URISyntaxException;
}