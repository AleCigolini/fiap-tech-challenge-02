package br.com.fiap.techchallenge01.core.utils.entity;

import jakarta.persistence.Column;

import java.time.OffsetDateTime;

public class JpaBaseEntity {

    @Column(name = "data_criacao")
    private OffsetDateTime dataCriacao;
    @Column(name = "data_atualizacao")
    private OffsetDateTime dataAtualizacao;

}
