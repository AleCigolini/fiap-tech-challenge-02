package br.com.fiap.techchallenge02.produto.application.usecase.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.SalvarCategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import org.springframework.stereotype.Service;

@Service
public class SalvarCategoriaProdutoUseCaseImpl implements SalvarCategoriaProdutoUseCase {

    private final CategoriaProdutoGateway categoriaProdutoGateway;

    public SalvarCategoriaProdutoUseCaseImpl(CategoriaProdutoGateway categoriaProdutoGateway) {
        this.categoriaProdutoGateway = categoriaProdutoGateway;
    }

    @Override
    public CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto) {
        return categoriaProdutoGateway.salvarCategoriaProduto(categoriaProduto);
    }
}
