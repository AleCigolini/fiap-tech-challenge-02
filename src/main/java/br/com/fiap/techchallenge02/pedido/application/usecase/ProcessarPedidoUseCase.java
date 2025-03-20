package br.com.fiap.techchallenge02.pedido.application.usecase;


import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.WebhookNotificationRequestDto;

public interface ProcessarPedidoUseCase {

    void processarNotificacao(WebhookNotificationRequestDto notificacao);
}
