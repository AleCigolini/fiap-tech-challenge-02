package br.com.fiap.techchallenge02.pagamento.application.controller.impl;

import br.com.fiap.techchallenge02.pagamento.application.controller.PagamentoController;
import br.com.fiap.techchallenge02.pagamento.application.presenter.PagamentoPresenter;
import br.com.fiap.techchallenge02.pagamento.application.usecase.ConsultarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class PagamentoControllerImpl implements PagamentoController {

    private final ConsultarPagamentoUseCase consultarPagamentoUseCase;
    private final PagamentoPresenter pagamentoPresenter;

    @Override
    public List<PagamentoResponseDto> buscarPagamentosPorPedidoId(String pedidoId) {
        return pagamentoPresenter.pagamentosParaPagamentoResponseDTOs(
                consultarPagamentoUseCase.buscarPagamentosPorPedidoId(pedidoId));
    }
}