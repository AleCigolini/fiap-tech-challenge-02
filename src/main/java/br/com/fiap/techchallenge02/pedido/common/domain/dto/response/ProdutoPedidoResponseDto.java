package br.com.fiap.techchallenge02.pedido.common.domain.dto.response;

import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProdutoPedidoResponseDto {

    @Schema(description = "Quantidade do produto no pedido")
    private Long quantidade;

    @Schema(description = "Observação do produto no pedido")
    private String observacao;

    @Schema(description = "Produto do pedido")
    private ProdutoResponseDTO produto;
}