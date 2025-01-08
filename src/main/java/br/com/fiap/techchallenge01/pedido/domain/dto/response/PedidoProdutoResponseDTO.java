package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PedidoProdutoResponseDTO {

    @Schema(description = "Nome do produto")
    private String nome;

    @Schema(description = "Categoria do produto (Lanche, Acompanhamento, Bebida, Sobremesa)")
    private PedidoProdutoCategoriaResponseDTO categoriaProduto;

    @Schema(description = "Preço do produto")
    private Double preco;

}