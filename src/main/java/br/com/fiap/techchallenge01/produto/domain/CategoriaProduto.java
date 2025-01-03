package br.com.fiap.techchallenge01.produto.domain;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CategoriaProduto {
    private Long id;
    private String nome;
    private OffsetDateTime dataCriacao;
    private Boolean eAtivo;
}
