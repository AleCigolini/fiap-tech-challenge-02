package br.com.fiap.techchallenge02.pagamento.common.domain.dto.request;

import lombok.Data;

@Data
public class WebhookNotificationRequestDto {
    private String type;
    private String action;
    private WebhookDataRequestDto data;
}