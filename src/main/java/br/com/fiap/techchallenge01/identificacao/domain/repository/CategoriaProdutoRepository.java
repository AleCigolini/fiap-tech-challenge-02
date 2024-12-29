package br.com.fiap.techchallenge01.identificacao.domain.repository;

import br.com.fiap.techchallenge01.identificacao.domain.CategoriaProduto;

import java.util.List;
import java.util.Optional;

public interface CategoriaProdutoRepository {

    CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto);
    Optional<CategoriaProduto> buscarCategoriaProdutoPorId(Long id);
    List<CategoriaProduto> buscarCategoriasProduto();
}
