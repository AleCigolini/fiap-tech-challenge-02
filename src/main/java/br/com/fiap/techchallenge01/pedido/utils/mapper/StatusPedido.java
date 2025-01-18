package br.com.fiap.techchallenge01.pedido.utils.mapper;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedido {

    ABERTO("Aberto"),
    APROVADO("Aprovado"),
    EM_ANDAMENTO("Em Andamento"),
    ENTREGUE("Entregue"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}