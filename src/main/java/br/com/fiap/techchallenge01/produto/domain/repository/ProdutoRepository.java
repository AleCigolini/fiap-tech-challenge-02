package br.com.fiap.techchallenge01.produto.domain.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import br.com.fiap.techchallenge01.produto.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    List<Produto> buscarProdutos();

    Optional<Produto> buscarProdutoPorId(Long id);

    Produto criarProduto(JpaProdutoEntity jpaProdutoEntity);

    Produto atualizarProduto(JpaProdutoEntity jpaProdutoEntity);

    void excluirProduto(Long idProduto);
}
