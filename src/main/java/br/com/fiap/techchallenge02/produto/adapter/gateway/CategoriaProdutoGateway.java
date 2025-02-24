package br.com.fiap.techchallenge02.produto.adapter.gateway;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

public interface CategoriaProdutoGateway {

    CategoriaProduto buscarCategoriaProdutoPorId(String id);
}
