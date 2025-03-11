package br.com.fiap.techchallenge02.produto_old.adapter.presenter;

import br.com.fiap.techchallenge02.produto_old.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto_old.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto_old.domain.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto_old.external.entity.JpaCategoriaProdutoEntity;

import java.util.List;

public interface CategoriaProdutoPresenter {

    CategoriaProduto jpaCategoriaProdutoEntityParaCategoriaProduto(JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity);

    CategoriaProdutoResponseDTO categoriaProdutoParaCategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto);

    JpaCategoriaProdutoEntity categoriaProdutoParaJpaCategoriaProdutoEntity(CategoriaProduto categoriaProduto);

    List<CategoriaProdutoResponseDTO> categoriasProdutoParaCategoriasProdutoResponseDTO(List<CategoriaProduto> categoriasProduto);

    CategoriaProduto categoriaProdutoRequestDTOParaCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO);
}