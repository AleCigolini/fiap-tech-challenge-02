package br.com.fiap.techchallenge01.pedido.domain.repository;

import br.com.fiap.techchallenge01.pedido.domain.Pagamento;

public interface PagamentoRepository {

    Pagamento enviarPagamento(Pagamento pagamento);
}