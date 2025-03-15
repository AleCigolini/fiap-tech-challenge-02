package br.com.fiap.techchallenge02.produto.application.presenter;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.common.dto.response.CategoriaProdutoResponseDTO;

import java.util.List;

public interface CategoriaProdutoPresenter {

    CategoriaProdutoResponseDTO categoriaProdutoParaCategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto);

    List<CategoriaProdutoResponseDTO> categoriasProdutoParaCategoriasProdutoResponseDTO(List<CategoriaProduto> categoriasProduto);
}