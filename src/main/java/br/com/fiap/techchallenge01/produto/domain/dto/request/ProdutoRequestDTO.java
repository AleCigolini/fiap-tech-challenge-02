package br.com.fiap.techchallenge01.produto.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoRequestDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String idCategoria;

    @NotNull
    private Double preco;

}
