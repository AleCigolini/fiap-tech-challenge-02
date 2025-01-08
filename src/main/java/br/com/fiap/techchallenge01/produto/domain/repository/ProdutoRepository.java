package br.com.fiap.techchallenge01.produto.domain.repository;

import br.com.fiap.techchallenge01.produto.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    List<Produto> buscarProdutos();

    Optional<Produto> buscarProdutoPorId(Long id);

    Produto criarProduto(Produto produto);

    Produto atualizarProduto(Produto produto);

    void excluirProduto(Long idProduto);

    List<Produto> buscarProdutosPorCategoria(Long idCategoriaProduto);
}
