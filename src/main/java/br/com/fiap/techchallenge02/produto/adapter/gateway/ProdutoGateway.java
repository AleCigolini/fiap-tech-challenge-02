package br.com.fiap.techchallenge02.produto.adapter.gateway;

import br.com.fiap.techchallenge02.produto.domain.Produto;

import java.util.List;

public interface ProdutoGateway {

    List<Produto> buscarProdutos();

}
