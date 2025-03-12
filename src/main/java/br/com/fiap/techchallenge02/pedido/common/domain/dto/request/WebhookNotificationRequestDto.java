package br.com.fiap.techchallenge02.pedido.common.domain.dto.request;

import lombok.Data;

@Data
public class WebhookNotificationRequestDto {
    private String type;
    private String action;
    private WebhookDataRequestDto data;
}