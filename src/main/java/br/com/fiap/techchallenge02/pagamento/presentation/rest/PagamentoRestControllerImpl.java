package br.com.fiap.techchallenge02.pagamento.presentation.rest;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pagamento.presentation.rest.interfaces.PagamentoRestController;
import br.com.fiap.techchallenge02.pagamento.application.controller.PagamentoController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoRestControllerImpl implements PagamentoRestController {

    private final PagamentoController pagamentoController;

    @Override
    @GetMapping("/pedidos/{pedidoId}")
    public ResponseEntity<List<PagamentoResponseDto>> buscarPagamentosPorPedidoId(@PathVariable String pedidoId) {
        List<PagamentoResponseDto> pagamentoResponseDTO = pagamentoController.buscarPagamentosPorPedidoId(pedidoId);

        return ResponseEntity.ok(pagamentoResponseDTO);
    }
}