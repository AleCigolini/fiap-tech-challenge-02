package br.com.fiap.techchallenge02.produto.adapter.in.config.mapper;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;

public interface ProdutoMapper {

    Produto produtoRequestDtoParaProduto(ProdutoRequestDTO produtoRequestDTO);
}
