package br.com.fiap.techchallenge02.produto.adapter.out.port;


import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

import java.util.List;
import java.util.Optional;

public interface CategoriaProdutoRepository {

    CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto);
    Optional<CategoriaProduto> buscarCategoriaProdutoPorId(String id);
    List<CategoriaProduto> buscarCategoriasProduto();
}
