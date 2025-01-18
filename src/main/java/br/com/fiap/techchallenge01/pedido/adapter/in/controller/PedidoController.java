package br.com.fiap.techchallenge01.pedido.adapter.in.controller;

import br.com.fiap.techchallenge01.pedido.adapter.in.controller.api.PedidoApi;
import br.com.fiap.techchallenge01.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController implements PedidoApi {

    private final PedidoUseCase pedidoUseCase;

    @Override
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> buscarPedidos() {
        List<PedidoResponseDTO> pedidosResponseDTO = pedidoUseCase.buscarPedidos();

        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO) throws URISyntaxException {
        PedidoResponseDTO pedidoResponse = pedidoUseCase.criarPedido(pedidoRequestDTO);

        return ResponseEntity.created(new URI("/pedidos/" + pedidoResponse.getId())).body(pedidoResponse);
    }
}
