package br.com.fiap.techchallenge02.pagamento.presentation.rest.interfaces;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.request.WebhookNotificationRequestDto;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.awt.image.BufferedImage;
import java.util.List;

@Tag(name = "${tag.swagger.pagamento.name}", description = "${tag.swagger.pagamento.description}")
public interface PagamentoRestController {

    /**
     * Busca todos os pagamentos pelo id do pedido
     *
     * @param pedidoId Id do pedido
     * @return {@link PagamentoResponseDto}
     */
    @Operation(summary = "Buscar todos os pagamentos pelo id do pedido",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Erros de validação",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Pagamento não encontrado",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    ResponseEntity<List<PagamentoResponseDto>> buscarPagamentosPorPedidoId(String pedidoId);

    /**
     * Retorna a imagem QRCode de um único caixa vinculado a uma única loja
     *
     * @return {@link BufferedImage}
     */
    @Operation(summary = "Retornar imagem QRCode de um único caixa vinculado a uma única loja",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Erros de validação",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Código QR não encontrado",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    ResponseEntity<BufferedImage> gerarImagemCodigoQRCaixa();

    /**
     * Recebe e processa notificações relacionadas ao pagamento dos pedidos
     *
     * @param notificacao Objeto com os dados da notificação
     */
    @Operation(summary = "Buscar todos os pagamentos pelo id do pedido",
            responses = {
                    @ApiResponse(responseCode = "202"),
                    @ApiResponse(responseCode = "400", description = "Erros de validação",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Pagamento ou pedido não encontrado",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
                    @ApiResponse(responseCode = "500", description = "Erro no procesamento da notificação de pagamento",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    void webhook(@RequestBody WebhookNotificationRequestDto notificacao);
}