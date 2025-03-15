package br.com.fiap.techchallenge02.pagamento.application.presenter;

import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;

import java.util.List;

public interface PagamentoPresenter {

    List<PagamentoResponseDto> pagamentosParaPagamentoResponseDTOs(List<Pagamento> pagamentos);
}