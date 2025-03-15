package br.com.fiap.techchallenge02.pagamento.infrastructure.database.adapter;

import br.com.fiap.techchallenge02.pagamento.common.domain.entity.JpaPagamentoEntity;
import br.com.fiap.techchallenge02.pagamento.common.interfaces.PagamentoDatabase;
import br.com.fiap.techchallenge02.pagamento.infrastructure.database.repository.JpaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagamentoJdbcAdapter implements PagamentoDatabase {

    private final JpaPagamentoRepository jpaPagamentoRepository;

    @Autowired
    public PagamentoJdbcAdapter(JpaPagamentoRepository jpaPagamentoRepository) {
        this.jpaPagamentoRepository = jpaPagamentoRepository;
    }

    @Override
    public List<JpaPagamentoEntity> buscarPagamentosPorPedidoId(String pedidoId) {
        return jpaPagamentoRepository.findByCodigoPedido(pedidoId);
    }

    @Override
    public JpaPagamentoEntity salvarPagamento(JpaPagamentoEntity jpaPagamentoEntity) {
        return jpaPagamentoRepository.save(jpaPagamentoEntity);
    }
}