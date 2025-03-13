package br.com.fiap.techchallenge02.pagamento.application.controller.impl;

import br.com.fiap.techchallenge02.pagamento.application.controller.PagamentoController;
import br.com.fiap.techchallenge02.pagamento.application.presenter.PagamentoPresenter;
import br.com.fiap.techchallenge02.pagamento.application.usecase.ConsultarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.application.usecase.SalvarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.request.WebhookNotificationRequestDto;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.awt.image.BufferedImage;
import java.util.List;

@Controller
@AllArgsConstructor
public class PagamentoControllerImpl implements PagamentoController {

    private final ConsultarPagamentoUseCase consultarPagamentoUseCase;
    private final SalvarPagamentoUseCase salvarPagamentoUseCase;
    private final PagamentoPresenter pagamentoPresenter;

    @Override
    public List<PagamentoResponseDto> buscarPagamentosPorPedidoId(String pedidoId) {
        return pagamentoPresenter.pagamentosParaPagamentoResponseDTOs(
                consultarPagamentoUseCase.buscarPagamentosPorPedidoId(pedidoId));
    }

    @Override
    public void processarNotificacao(WebhookNotificationRequestDto notificacao) {
        salvarPagamentoUseCase.processarNotificacao(notificacao);
    }

    @Override
    public BufferedImage gerarImagemCodigoQRCaixa() {
        return salvarPagamentoUseCase.gerarImagemCodigoQRCaixa();
    }
}