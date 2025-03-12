package br.com.fiap.techchallenge02.pedido.infrastructure.database.adapter;

import br.com.fiap.techchallenge02.pedido.common.domain.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge02.pedido.common.interfaces.PedidoDatabase;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.pedido.infrastructure.database.repository.JpaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoJdbcAdapter implements PedidoDatabase {

    private final JpaPedidoRepository jpaPedidoRepository;

    @Autowired
    public PedidoJdbcAdapter(JpaPedidoRepository jpaPedidoRepository) {
        this.jpaPedidoRepository = jpaPedidoRepository;
    }

    @Override
    public List<JpaPedidoEntity> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums) {
        List<String> status = statusPedidoEnums.stream().map(StatusPedidoEnum::toString).toList();
        return jpaPedidoRepository.findAllByStatusIn(status);
    }

    @Override
    public JpaPedidoEntity criarPedido(JpaPedidoEntity jpaPedidoEntity) {
        return jpaPedidoRepository.save(jpaPedidoEntity);
    }
}