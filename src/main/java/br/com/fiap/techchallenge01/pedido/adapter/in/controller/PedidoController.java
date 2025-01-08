package br.com.fiap.techchallenge01.pedido.adapter.in.controller;

import br.com.fiap.techchallenge01.pedido.adapter.in.controller.api.PedidoApi;
import br.com.fiap.techchallenge01.pedido.application.service.PedidoService;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.pedido.utils.mapper.PedidoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController implements PedidoApi {

    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    public PedidoController(PedidoService pedidoService, PedidoMapper pedidoMapper) {
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> buscarPedidos() {
        List<PedidoResponseDTO> pedidosResponseDTO = pedidoService.buscarPedidos();

        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO) throws URISyntaxException {
        PedidoResponseDTO pedidoResponse = pedidoService.criarPedido(pedidoRequestDTO);

        return ResponseEntity.created(new URI(STR."/pedidos/\{pedidoResponse.getId()}")).body(pedidoResponse);
    }
}
