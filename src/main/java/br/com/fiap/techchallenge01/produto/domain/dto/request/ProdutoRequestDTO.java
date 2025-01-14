package br.com.fiap.techchallenge01.produto.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoRequestDTO {
    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotNull
    private String idCategoria;

    @NotNull
    private Double preco;

}
