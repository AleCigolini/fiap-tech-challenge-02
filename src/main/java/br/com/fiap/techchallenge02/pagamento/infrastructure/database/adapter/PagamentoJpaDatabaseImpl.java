package br.com.fiap.techchallenge02.pagamento.infrastructure.database.adapter;

import br.com.fiap.techchallenge02.pagamento.common.domain.entity.JpaPagamentoEntity;
import br.com.fiap.techchallenge02.pagamento.common.interfaces.PagamentoDatabase;
import br.com.fiap.techchallenge02.pagamento.infrastructure.database.repository.JpaPagamentoRepository;
import br.com.fiap.techchallenge02.pedido.common.domain.entity.JpaPedidoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PagamentoJpaDatabaseImpl implements PagamentoDatabase {

    private final JpaPagamentoRepository jpaPagamentoRepository;

    public PagamentoJpaDatabaseImpl(JpaPagamentoRepository jpaPagamentoRepository) {
        this.jpaPagamentoRepository = jpaPagamentoRepository;
    }

    @Override
    public List<JpaPagamentoEntity> buscarPagamentosPorPedidoId(String pedidoId) {
        JpaPedidoEntity pedido = new JpaPedidoEntity();
        pedido.setId(UUID.fromString(pedidoId));
        return jpaPagamentoRepository.findByPedido(pedido);
    }

    @Override
    public JpaPagamentoEntity salvarPagamento(JpaPagamentoEntity jpaPagamentoEntity) {
        return jpaPagamentoRepository.save(jpaPagamentoEntity);
    }
}