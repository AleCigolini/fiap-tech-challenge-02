package br.com.fiap.techchallenge02.pedido.external.rest;

import br.com.fiap.techchallenge02.pedido.adapter.controller.PedidoController;
import br.com.fiap.techchallenge02.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge02.pedido.external.rest.api.PedidoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoRest implements PedidoApi {

    private final PedidoController pedidoController;

    @Override
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> buscarPedidos(@RequestParam("status") List<String> status) {
        List<PedidoResponseDTO> pedidosResponseDTO = pedidoController.buscarPedidos(status);

        return ResponseEntity.ok(pedidosResponseDTO);
    }
}
