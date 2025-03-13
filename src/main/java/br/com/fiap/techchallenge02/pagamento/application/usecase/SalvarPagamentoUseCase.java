package br.com.fiap.techchallenge02.pagamento.application.usecase;

import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;

import java.util.List;

public interface SalvarPagamentoUseCase {

    Pagamento salvarPagamento(Pagamento pagamento);
}
