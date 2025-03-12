package br.com.fiap.techchallenge02.pedido.presentation.rest;

import br.com.fiap.techchallenge02.pedido.application.controller.PedidoController;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoStatusRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import br.com.fiap.techchallenge02.pedido.presentation.rest.interfaces.PedidoRestController;
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
public class PedidoRestControllerImpl implements PedidoRestController {

    private final PedidoController pedidoController;

    @Override
    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> buscarPedidos(@RequestParam(value="status", required=false) List<String> status) {
        List<PedidoResponseDto> pedidosResponseDTO = pedidoController.buscarPedidos(status);

        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody @Valid PedidoRequestDto pedidoRequestDTO) throws URISyntaxException {
        PedidoResponseDto pedidoResponse = pedidoController.criarPedido(pedidoRequestDTO);

        return ResponseEntity.created(new URI("/pedidos/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> atualizarStatusPedido(@RequestBody @Valid PedidoStatusRequestDto pedidoStatusRequestDTO, @PathVariable String id) {
        PedidoResponseDto pedidoResponseDTO = pedidoController.atualizarStatusPedido(pedidoStatusRequestDTO, id);

        return ResponseEntity.ok(pedidoResponseDTO);
    }

//      TODO: MOVER PARA O MÓDULO PAGAMENTO
//    @Override
//    @GetMapping("/{idPedido}/pagamento")
//    public ResponseEntity<PagamentoResponseDto> verificarPagamentoPedido(@PathVariable String idPedido) {
//        PagamentoResponseDto pagamentoResponseDTO = pedidoController.verificarPagamentoPedido(idPedido);
//
//        return ResponseEntity.ok(pagamentoResponseDTO);
//    }
}
