package br.com.fiap.techchallenge02.produto_old.application.usecase;

import br.com.fiap.techchallenge02.produto_old.domain.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoUseCase {

    CategoriaProduto buscarCategoriaProdutoPorId(String id);

    List<CategoriaProduto> buscarCategoriasProduto();

    CategoriaProduto criarCategoriaProduto(CategoriaProduto categoriaProduto);
}
