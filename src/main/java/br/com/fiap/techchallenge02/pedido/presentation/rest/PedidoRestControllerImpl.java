package br.com.fiap.techchallenge02.pedido.presentation.rest;

import br.com.fiap.techchallenge02.pedido.application.controller.PedidoController;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.WebhookNotificationRequestDto;
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
    public ResponseEntity<List<PedidoResponseDto>> buscarPedidos(@RequestParam("status") List<String> status) {
        List<PedidoResponseDto> pedidosResponseDTO = pedidoController.buscarPedidos(status);

        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody @Valid PedidoRequestDto pedidoRequestDTO) throws URISyntaxException {
        PedidoResponseDto pedidoResponse = pedidoController.criarPedido(pedidoRequestDTO);

        return ResponseEntity.created(new URI("/pedidos/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    // Recebe a notificação POST do Mercado Pago
    @Override
    @PostMapping("/webhook")
    public void webhook(@RequestBody WebhookNotificationRequestDto notificacao,
                        @RequestHeader("X-MercadoPago-Signature") String signature) {
        // O Mercado Pago envia o "notification" com os detalhes da transação.
        // A string "notificacao" pode ser um JSON que você precisa parsear
        // para identificar o status do pagamento.
        System.out.println("Recebido Webhook: " + notificacao);
        if (isSignatureValid(notificacao, signature)) {
            System.out.println("Pagamento " + notificacao.getAction() + " para ID: " + notificacao.getData().getId());

            pedidoController.processarNotificacao(notificacao);
        } else {
            System.out.println("Assinatura inválida");
        }
    }

    private boolean isSignatureValid(WebhookNotificationRequestDto notification, String signature) {
        // Verificar assinatura com o segredo compartilhado
        return true; // Aqui você validaria a assinatura
    }
}
