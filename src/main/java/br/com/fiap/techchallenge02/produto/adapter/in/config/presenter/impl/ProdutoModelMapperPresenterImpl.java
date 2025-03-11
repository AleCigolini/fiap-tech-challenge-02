package br.com.fiap.techchallenge02.produto.adapter.in.config.presenter.impl;

import br.com.fiap.techchallenge02.produto.adapter.in.config.presenter.ProdutoPresenter;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoModelMapperPresenterImpl implements ProdutoPresenter {

    private final ModelMapper modelMapper;

    public ProdutoModelMapperPresenterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos) {
        return produtos.stream().map(produto -> modelMapper.map(produto, ProdutoResponseDTO.class)).toList();
    }

    @Override
    public ProdutoResponseDTO produtoParaProdutoResponseDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDTO.class);
    }
}
