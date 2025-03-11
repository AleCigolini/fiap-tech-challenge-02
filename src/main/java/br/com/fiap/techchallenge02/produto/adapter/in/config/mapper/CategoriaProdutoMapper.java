package br.com.fiap.techchallenge02.produto.adapter.in.config.mapper;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.CategoriaProdutoRequestDTO;

public interface CategoriaProdutoMapper {

    CategoriaProduto categoriaProdutoRequestDTOParaCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO);
}
