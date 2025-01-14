package br.com.fiap.techchallenge01.pedido.adapter.out.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPagamentoEntity;
import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaProdutoPedidoEntity;
import br.com.fiap.techchallenge01.pedido.domain.Pagamento;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.ProdutoPedido;
import br.com.fiap.techchallenge01.pedido.domain.repository.PagamentoRepository;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PagamentoRepositoryImpl implements PagamentoRepository {

    @Autowired
    private JpaPagamentoRepository jpaPagamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Pagamento enviarPagamento(Pagamento pagamento) {
        JpaPagamentoEntity jpaPagamentoEntity = modelMapper.map(pagamento, JpaPagamentoEntity.class);

        JpaPagamentoEntity jpaPagamentoEntitySalvo = jpaPagamentoRepository.save(jpaPagamentoEntity);

        return modelMapper.map(jpaPagamentoEntitySalvo, Pagamento.class);
    }
}
