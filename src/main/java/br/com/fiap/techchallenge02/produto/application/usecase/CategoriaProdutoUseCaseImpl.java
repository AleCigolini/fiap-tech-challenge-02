package br.com.fiap.techchallenge02.produto.application.usecase;

import br.com.fiap.techchallenge02.produto.adapter.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

import java.util.List;

public class CategoriaProdutoUseCaseImpl implements CategoriaProdutoUseCase {

    private final CategoriaProdutoGateway categoriaProdutoGateway;

    public CategoriaProdutoUseCaseImpl(CategoriaProdutoGateway categoriaProdutoGateway) {
        this.categoriaProdutoGateway = categoriaProdutoGateway;
    }

    @Override
    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoGateway.buscarCategoriaProdutoPorId(id);
    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return categoriaProdutoGateway.buscarCategoriasProduto();
    }

    @Override
    public CategoriaProduto criarCategoriaProduto(CategoriaProduto categoriaProduto) {
        categoriaProduto.setAtivo(true);
        return categoriaProdutoGateway.criarCategoriaProduto(categoriaProduto);
    }
}
