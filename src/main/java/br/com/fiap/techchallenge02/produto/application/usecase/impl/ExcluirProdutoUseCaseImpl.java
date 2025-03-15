package br.com.fiap.techchallenge02.produto.application.usecase.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.ExcluirProdutoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ExcluirProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public void excluirProduto(String idProduto) {
        produtoGateway.excluirProduto(idProduto);
    }
}

