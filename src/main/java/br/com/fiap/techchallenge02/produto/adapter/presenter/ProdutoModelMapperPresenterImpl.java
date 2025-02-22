package br.com.fiap.techchallenge02.produto.adapter.presenter;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.external.entity.JpaProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoModelMapperPresenterImpl implements ProdutoPresenter {

    private final ModelMapper modelMapper;

    public ProdutoModelMapperPresenterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<Produto> jpaProdutoEntityParaProduto(List<JpaProdutoEntity> jpaProdutoEntities) {
        return jpaProdutoEntities.stream().map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class)).toList();
    }

    public List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos) {
        return produtos.stream().map(produto -> modelMapper.map(produto, ProdutoResponseDTO.class)).toList();
    }
}
