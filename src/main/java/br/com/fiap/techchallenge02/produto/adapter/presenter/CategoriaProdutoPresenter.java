package br.com.fiap.techchallenge02.produto.adapter.presenter;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.external.entity.JpaCategoriaProdutoEntity;

public interface CategoriaProdutoPresenter {

    CategoriaProduto jpaCategoriaProdutoEntityParaCategoriaProduto(JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity);
}
