package br.com.fiap.techchallenge02.produto.adapter.gateway;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoGateway {

    CategoriaProduto buscarCategoriaProdutoPorId(String id);

    List<CategoriaProduto> buscarCategoriasProduto();

    CategoriaProduto criarCategoriaProduto(CategoriaProduto categoriaProduto);
}
