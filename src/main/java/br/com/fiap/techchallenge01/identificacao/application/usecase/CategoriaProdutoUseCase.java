package br.com.fiap.techchallenge01.identificacao.application.usecase;

import br.com.fiap.techchallenge01.identificacao.domain.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoUseCase {

    CategoriaProduto salvarCategoriaProduto(CategoriaProduto usuario);
    CategoriaProduto buscarCategoriaProdutoPorId(Long id);
    List<CategoriaProduto> buscarCategoriasProduto();
}
