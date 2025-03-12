package br.com.fiap.techchallenge02.pedido.presentation.rest.interfaces;

import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.WebhookNotificationRequestDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.URISyntaxException;
import java.util.List;

@Tag(name = "${tag.swagger.pedido.name}", description = "${tag.swagger.pedido.description}")
public interface PedidoRestController {

    /**
     * Busca todos os pedidos
     *
     * @return {@link PedidoResponseDto}
     */
    @Operation(summary = "Buscar todos os pedidos",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Erros de validação",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Cliente não encntrado",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    ResponseEntity<List<PedidoResponseDto>> buscarPedidos(@Parameter(name = "status", description = "Aberto, Aprovado, Em Andamento, Entregue, Finalizado, Cancelado") List<String> status);

    /**
     * Criar pedido
     *
     * @param pedidoRequestDTO DTO para criação de pedido
     * @return {@link PedidoResponseDto}
     */
    @Operation(summary = "Criar novo pedido",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Erro no cadastro do pedido/Erros de validação",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
            })
    ResponseEntity<PedidoResponseDto> criarPedido(PedidoRequestDto pedidoRequestDTO) throws URISyntaxException;

    void webhook(@RequestBody WebhookNotificationRequestDto notification, @RequestHeader("X-MercadoPago-Signature") String signature);
}
