package br.com.fiap.techchallenge02.pedido.external.rest.api;

import br.com.fiap.techchallenge02.pedido.domain.dto.response.PedidoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "${tag.swagger.pedido.name}", description = "${tag.swagger.pedido.description}")
public interface PedidoApi {

    /**
     * Busca todos os pedidos
     *
     * @return {@link PedidoResponseDTO}
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
    ResponseEntity<List<PedidoResponseDTO>> buscarPedidos(@Parameter(name = "status", description = "Aberto, Aprovado, Em Andamento, Entregue, Finalizado, Cancelado") List<String> status);
}