package br.com.fiap.techchallenge01.core.utils.domain;

import java.time.OffsetDateTime;

public class DominioBase {
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
