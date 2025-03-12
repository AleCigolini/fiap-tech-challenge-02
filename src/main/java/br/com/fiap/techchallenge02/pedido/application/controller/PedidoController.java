package br.com.fiap.techchallenge02.pedido.application.controller;

import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.WebhookNotificationRequestDto;

import java.util.List;

public interface PedidoController {

    List<PedidoResponseDto> buscarPedidos(List<String> status);

    PedidoResponseDto criarPedido(PedidoRequestDto pedidoRequestDTO);

    void processarNotificacao(WebhookNotificationRequestDto notificacao);
}