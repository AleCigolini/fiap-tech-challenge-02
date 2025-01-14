package br.com.fiap.techchallenge01.produto.domain.dto.response;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProdutoResponseDTO {

    @Schema(description = "Identificador único do produto", example = "e389406d-5531-4acf-a354-be5cc46a8cb1")
    private String id;

    @Schema(description = "Nome do produto")
    private String nome;

    @Schema(description = "Descrição do produto")
    private String descricao;

    @Schema(description = "Categoria do produto (Lanche, Acompanhamento, Bebida, Sobremesa)")
    private CategoriaProduto categoriaProduto;

    @Schema(description = "Preço do produto")
    private Double preco;
}