package br.com.fiap.techchallenge01.produto.domain.repository;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;

import java.util.Optional;

public interface CategoriaProdutoRepository {

    Optional<CategoriaProduto> buscarCategoriaProdutoPorId(Long id);
}
