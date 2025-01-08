package br.com.fiap.techchallenge01.pedido.utils.mapper;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    private final ModelMapper modelMapper;

    public PedidoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PedidoResponseDTO toResponse(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResponseDTO.class);
    }

    public List<PedidoResponseDTO> toCollectionResponse(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public JpaPedidoEntity toJpaPedidoEntity(List<Produto> produtos) {

        JpaPedidoEntity jpaPedidoEntity = new JpaPedidoEntity();
        JpaProdutoEntity jpaProdutoEntity;
        double valor = 0D;

        List<JpaProdutoEntity> jpaProdutoEntities = new ArrayList<>();

        for (Produto produto : produtos) {
            jpaProdutoEntity = new JpaProdutoEntity();
            jpaProdutoEntity.setId(produto.getId());
            valor = valor + produto.getPreco();
            jpaProdutoEntities.add(jpaProdutoEntity);
        }

        jpaPedidoEntity.setCodigo("00001"); //TODO: SEMPRE GERAR UMA NOVA SEQUENCIA POR DIA
        jpaPedidoEntity.setStatus("Aberto");
        jpaPedidoEntity.setValor(valor);
//        jpaPedidoEntity.setProdutos(jpaProdutoEntities);
        return jpaPedidoEntity;
    }
}