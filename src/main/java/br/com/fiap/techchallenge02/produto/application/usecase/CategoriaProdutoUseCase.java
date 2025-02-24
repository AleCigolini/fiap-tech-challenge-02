package br.com.fiap.techchallenge02.produto.application.usecase;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

public interface CategoriaProdutoUseCase {

    CategoriaProduto buscarCategoriaProdutoPorId(String id);
}
