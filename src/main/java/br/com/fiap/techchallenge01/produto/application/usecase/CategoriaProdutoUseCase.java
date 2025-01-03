package br.com.fiap.techchallenge01.produto.application.usecase;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;

public interface CategoriaProdutoUseCase {

    CategoriaProduto buscarCategoriaProdutoPorId(Long idCategoriaProduto);
}
