package br.com.fiap.techchallenge02.produto.application.mapper;

import br.com.fiap.techchallenge02.produto.common.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.common.entity.JpaProdutoEntity;
import br.com.fiap.techchallenge02.produto.domain.Produto;

public interface ProdutoMapper {

    Produto produtoRequestDtoParaProduto(ProdutoRequestDTO produtoRequestDTO);

    Produto jpaProdutoEntityParaProduto(JpaProdutoEntity jpaProdutoEntity);

    JpaProdutoEntity produtoParaJpaProdutoEntity(Produto produto);
}
