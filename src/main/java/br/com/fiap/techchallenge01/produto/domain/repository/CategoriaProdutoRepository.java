package br.com.fiap.techchallenge01.produto.domain.repository;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;

import java.util.List;
import java.util.Optional;

public interface CategoriaProdutoRepository {

    CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto);
    Optional<CategoriaProduto> buscarCategoriaProdutoPorId(String id);
    List<CategoriaProduto> buscarCategoriasProduto();
    CategoriaProduto alterarNomeCategoriaProduto(String id, CategoriaProduto categoriaProduto);
    void desativarCategoriaProduto(CategoriaProduto categoriaProduto);
}
