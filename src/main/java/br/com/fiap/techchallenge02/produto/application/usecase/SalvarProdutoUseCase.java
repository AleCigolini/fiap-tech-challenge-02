package br.com.fiap.techchallenge02.produto.application.usecase;


import br.com.fiap.techchallenge02.produto.domain.Produto;

public interface SalvarProdutoUseCase {
    Produto criarProduto(Produto produto);
}
