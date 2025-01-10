package br.com.fiap.techchallenge01.pedido.adapter.out.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaProdutoPedidoEntity;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.ProdutoPedido;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Autowired
    private JpaProdutoPedidoRepository jpaProdutoPedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

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

        JpaPedidoEntity jpaPedidoEntitySalvo = jpaPedidoRepository.save(jpaPedidoEntity);

        for (ProdutoPedido produtoPedido : pedido.getProdutos()) {
            JpaProdutoPedidoEntity jpaProdutoPedidoEntity = modelMapper.map(produtoPedido, JpaProdutoPedidoEntity.class);
            jpaProdutoPedidoEntity.setPedido(jpaPedidoEntitySalvo);
            jpaProdutoPedidoEntity.setAtivo(Boolean.TRUE);
            jpaProdutoPedidoRepository.save(jpaProdutoPedidoEntity);
        }

        return modelMapper.map(jpaPedidoEntitySalvo, Pedido.class);
    }
}
