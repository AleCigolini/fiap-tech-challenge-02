package br.com.fiap.techchallenge01.produto.domain;

import java.time.OffsetDateTime;

public class CategoriaProduto {

    private String id;
    private String nome;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;
    private Boolean ativo;

    public CategoriaProduto() {

    }

    public CategoriaProduto(String id, String nome, OffsetDateTime dataCriacao, OffsetDateTime dataAtualizacao, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}