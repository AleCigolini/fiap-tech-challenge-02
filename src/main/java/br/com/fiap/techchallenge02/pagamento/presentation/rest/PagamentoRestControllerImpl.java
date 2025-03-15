package br.com.fiap.techchallenge02.pagamento.presentation.rest;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.request.WebhookNotificationRequestDto;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pagamento.presentation.rest.interfaces.PagamentoRestController;
import br.com.fiap.techchallenge02.pagamento.application.controller.PagamentoController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @PostMapping("/webhook")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void webhook(@RequestBody WebhookNotificationRequestDto notificacao,
                        @RequestHeader("X-MercadoPago-Signature") String assinatura) {
        // TODO: O Mercado Pago envia o "notification" com os detalhes da transação.
        //  A string "notificacao" pode ser um JSON que você precisa parsear
        //  para identificar o status do pagamento.
        System.out.println("Recebido Webhook: " + notificacao);
        if (isSignatureValid(notificacao, assinatura)) {
            System.out.println("Pagamento " + notificacao.getAction() + " para ID: " + notificacao.getData().getId());

            pagamentoController.processarNotificacao(notificacao);
        } else {
            System.out.println("Assinatura inválida");
        }
    }

    private boolean isSignatureValid(WebhookNotificationRequestDto notificacao, String assinatura) {
        // TODO: Verificar assinatura com o segredo compartilhado
        return true;
    }
}