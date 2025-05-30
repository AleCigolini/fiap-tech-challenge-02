package br.com.fiap.techchallenge02.pagamento.common.interfaces;

import br.com.fiap.techchallenge02.pagamento.common.domain.entity.JpaPagamentoEntity;

import java.util.List;

public interface PagamentoDatabase {

    List<JpaPagamentoEntity> buscarPagamentosPorPedidoId(String pedidoId);

    JpaPagamentoEntity salvarPagamento(JpaPagamentoEntity jpaPagamentoEntity);
}