package br.com.fiap.techchallenge02.pagamento.presentation.rest;

import br.com.fiap.techchallenge02.pagamento.application.controller.PagamentoController;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pagamento.presentation.rest.interfaces.PagamentoRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
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

    @Override
    @GetMapping(value = "/caixa/qr-code", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> gerarImagemCodigoQRCaixa() {
        return ResponseEntity.ok(pagamentoController.gerarImagemCodigoQRCaixa());
    }
}