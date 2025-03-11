package br.com.fiap.techchallenge02.produto_old.adapter.gateway;

import br.com.fiap.techchallenge02.produto_old.domain.Produto;

import java.util.List;

public interface ProdutoGateway {

    List<Produto> buscarProdutos();

    List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto);

    Produto buscarProdutoPorId(String id);

    Produto criarProduto(Produto produto);

    Produto atualizarProduto(Produto produto);

    void excluirProduto(String idProduto);
}
