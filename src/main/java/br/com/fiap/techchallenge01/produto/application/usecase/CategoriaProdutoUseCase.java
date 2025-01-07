package br.com.fiap.techchallenge01.produto.application.usecase;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoUseCase {

    CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto);
    CategoriaProduto buscarCategoriaProdutoPorId(Long id);
    List<CategoriaProduto> buscarCategoriasProduto();
    CategoriaProduto alterarNomeCategoriaProduto(Long id, CategoriaProduto categoriaProduto);
    void desativarCategoriaProduto(CategoriaProduto categoriaProduto);
}
