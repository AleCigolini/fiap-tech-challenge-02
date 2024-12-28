package br.com.fiap.techchallenge01.produto.application.usecase;

import br.com.fiap.techchallenge01.produto.domain.Produto;

import java.util.List;

public interface ProdutoUseCase {

    List<Produto> buscarProdutos();

    Produto buscarProdutoPorId(Long id);
}
