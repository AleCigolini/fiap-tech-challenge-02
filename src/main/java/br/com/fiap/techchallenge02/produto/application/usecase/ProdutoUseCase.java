package br.com.fiap.techchallenge02.produto.application.usecase;


import br.com.fiap.techchallenge02.produto.domain.Produto;

import java.util.List;

public interface ProdutoUseCase {

    List<Produto> buscarProdutos();

    Produto buscarProdutoPorId(String id);

    Produto criarProduto(Produto produto);

    Produto atualizarProduto(Produto produto);

    void excluirProduto(String idProduto);

    List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto);
}
