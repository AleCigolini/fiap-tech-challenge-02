package br.com.fiap.techchallenge02.pedido.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPedidoEnum {

    ABERTO("Aberto"),
    APROVADO("Aprovado"),
    EM_ANDAMENTO("Em Andamento"),
    ENTREGUE("Entregue"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String status;

    StatusPedidoEnum(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    public static StatusPedidoEnum fromStringStatus(String status) {
        for (StatusPedidoEnum valoresStatusPedidoEnum : StatusPedidoEnum.values()) {
            if (valoresStatusPedidoEnum.getStatus().equals(status)) {
                return valoresStatusPedidoEnum;
            }
        }

        return StatusPedidoEnum.ABERTO;
    }
}