package br.com.fiap.techchallenge02.pagamento.presentation.rest.interfaces;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

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
                    @ApiResponse(responseCode = "404", description = "Pagamento não encntrado",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    ResponseEntity<List<PagamentoResponseDto>> buscarPagamentosPorPedidoId(String pedidoId);
}