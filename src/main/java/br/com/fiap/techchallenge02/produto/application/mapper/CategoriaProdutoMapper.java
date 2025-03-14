package br.com.fiap.techchallenge02.produto.application.mapper;

import br.com.fiap.techchallenge02.produto.common.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.common.dto.request.CategoriaProdutoRequestDTO;

public interface CategoriaProdutoMapper {

    CategoriaProduto categoriaProdutoRequestDTOParaCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO);
    JpaCategoriaProdutoEntity categoriaProdutoParaJpaCategoriaProdutoEntity(CategoriaProduto categoriaProduto);
    CategoriaProduto jpaCategoriaProdutoEntityParaCategoriaProduto(JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity);
}
