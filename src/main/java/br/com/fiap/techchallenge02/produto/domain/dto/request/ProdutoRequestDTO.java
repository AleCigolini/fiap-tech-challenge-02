package br.com.fiap.techchallenge02.produto.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRequestDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String idCategoria;

    @NotNull
    private BigDecimal preco;

}
