package br.com.fiap.techchallenge02.produto.adapter.in.config.presenter;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.CategoriaProdutoResponseDTO;

import java.util.List;

public interface CategoriaProdutoPresenter {

    CategoriaProdutoResponseDTO categoriaProdutoParaCategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto);

    List<CategoriaProdutoResponseDTO> categoriasProdutoParaCategoriasProdutoResponseDTO(List<CategoriaProduto> categoriasProduto);
}