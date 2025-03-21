package br.com.fiap.techchallenge02.produto.application.usecase;


import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

import java.util.List;

public interface BuscarCategoriaProdutoUseCase {
    CategoriaProduto buscarCategoriaProdutoPorId(String id);
    List<CategoriaProduto> buscarCategoriasProduto();
}
