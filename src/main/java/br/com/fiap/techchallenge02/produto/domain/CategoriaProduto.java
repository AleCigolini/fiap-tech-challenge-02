package br.com.fiap.techchallenge02.produto.domain;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CategoriaProduto {

    private String id;
    private String nome;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;
    private Boolean ativo = Boolean.TRUE;
}