package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProdutoPedidoResponseDTO {

    @Schema(description = "Observação do produto no pedido")
    private String observacao;

    @Schema(description = "Produto do pedido")
    private ProdutoResponseDTO produto;
}