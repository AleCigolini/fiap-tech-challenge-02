package br.com.fiap.techchallenge02.pagamento.application.usecase;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.request.WebhookNotificationRequestDto;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;

import java.awt.image.BufferedImage;

public interface SalvarPagamentoUseCase {

    Pagamento salvarPagamentoDoPedido(Pedido pedido);

    void processarNotificacao(WebhookNotificationRequestDto notificacao);

    BufferedImage gerarImagemCodigoQRCaixa();
}
