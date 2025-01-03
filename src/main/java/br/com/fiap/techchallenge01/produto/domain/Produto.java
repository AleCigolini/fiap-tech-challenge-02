package br.com.fiap.techchallenge01.produto.domain;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Long idCategoria;
    private Double preco;
    private OffsetDateTime dataCriacao;
    private Boolean eAtivo;
}
