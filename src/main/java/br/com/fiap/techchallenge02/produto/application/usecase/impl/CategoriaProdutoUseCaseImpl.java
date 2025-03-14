package br.com.fiap.techchallenge02.produto.application.usecase.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.common.exception.CategoriaProdutoNaoEncontradaException;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProdutoUseCaseImpl implements CategoriaProdutoUseCase {

    private final CategoriaProdutoGateway categoriaProdutoGateway;

    public CategoriaProdutoUseCaseImpl(CategoriaProdutoGateway categoriaProdutoGateway) {
        this.categoriaProdutoGateway = categoriaProdutoGateway;
    }

    @Override
    public CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto) {
        return categoriaProdutoGateway.salvarCategoriaProduto(categoriaProduto);
    }

    @Override
    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoGateway.buscarCategoriaProdutoPorId(id).orElseThrow(() -> new CategoriaProdutoNaoEncontradaException(id));
    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return categoriaProdutoGateway.buscarCategoriasProduto();
    }
}
