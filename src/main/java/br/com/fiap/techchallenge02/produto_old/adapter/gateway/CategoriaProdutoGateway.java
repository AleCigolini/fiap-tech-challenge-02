package br.com.fiap.techchallenge02.produto_old.adapter.gateway;

import br.com.fiap.techchallenge02.produto_old.domain.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoGateway {

    CategoriaProduto buscarCategoriaProdutoPorId(String id);

    List<CategoriaProduto> buscarCategoriasProduto();

    CategoriaProduto criarCategoriaProduto(CategoriaProduto categoriaProduto);
}
