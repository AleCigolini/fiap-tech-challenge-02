package br.com.fiap.techchallenge02.produto.application.usecase;

import br.com.fiap.techchallenge02.produto.adapter.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

public class CategoriaProdutoUseCaseImpl implements CategoriaProdutoUseCase {

    private final CategoriaProdutoGateway categoriaProdutoGateway;

    public CategoriaProdutoUseCaseImpl(CategoriaProdutoGateway categoriaProdutoGateway) {
        this.categoriaProdutoGateway = categoriaProdutoGateway;
    }

    @Override
    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoGateway.buscarCategoriaProdutoPorId(id);
    }
}
