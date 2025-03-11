package br.com.fiap.techchallenge02.produto.adapter.in.config.presenter.impl;

import br.com.fiap.techchallenge02.produto.adapter.in.config.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.CategoriaProdutoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaProdutoModelMapperPresenterImpl implements CategoriaProdutoPresenter {

    private final ModelMapper modelMapper;

    public CategoriaProdutoModelMapperPresenterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoriaProdutoResponseDTO categoriaProdutoParaCategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto) {
        return modelMapper.map(categoriaProduto, CategoriaProdutoResponseDTO.class);
    }

    @Override
    public List<CategoriaProdutoResponseDTO> categoriasProdutoParaCategoriasProdutoResponseDTO(List<CategoriaProduto> categoriasProduto) {
        return categoriasProduto.stream().map(categoriaProduto -> modelMapper.map(categoriaProduto, CategoriaProdutoResponseDTO.class)).toList();
    }
}
