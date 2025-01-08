package br.com.fiap.techchallenge01.pedido.adapter.out.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final JpaPedidoRepository jpaPedidoRepository;
    private final ModelMapper modelMapper;

    public PedidoRepositoryImpl(JpaPedidoRepository jpaPedidoRepository, ModelMapper modelMapper) {
        this.jpaPedidoRepository = jpaPedidoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return jpaPedidoRepository.findAll()
                .stream()
                .map(jpaPedidoEntity -> modelMapper.map(jpaPedidoEntity, Pedido.class))
                .collect(Collectors.toList());
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        JpaPedidoEntity jpaPedidoEntity = modelMapper.map(pedido, JpaPedidoEntity.class);
        // TODO: RESOLVER O PROBLEMA MUITOS:MUITOS ENTRE PEDIDO E PRODUTO
        JpaPedidoEntity jpaPedidoEntitySalvo = jpaPedidoRepository.save(jpaPedidoEntity);

        return modelMapper.map(jpaPedidoEntitySalvo, Pedido.class);
    }
}
