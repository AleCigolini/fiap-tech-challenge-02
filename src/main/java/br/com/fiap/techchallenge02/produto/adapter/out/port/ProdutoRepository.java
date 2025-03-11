package br.com.fiap.techchallenge02.produto.adapter.out.port;


import br.com.fiap.techchallenge02.produto.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    List<Produto> buscarProdutos();

    Optional<Produto> buscarProdutoPorId(String id);

    Produto criarProduto(Produto produto);

    Produto atualizarProduto(Produto produto);

    void excluirProduto(String idProduto);

    List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto);
}
