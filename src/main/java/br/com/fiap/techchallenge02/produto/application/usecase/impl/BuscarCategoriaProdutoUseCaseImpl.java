package br.com.fiap.techchallenge02.produto.application.usecase.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.BuscarCategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.common.exception.CategoriaProdutoNaoEncontradaException;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarCategoriaProdutoUseCaseImpl implements BuscarCategoriaProdutoUseCase {

    private final CategoriaProdutoGateway categoriaProdutoGateway;

    public BuscarCategoriaProdutoUseCaseImpl(CategoriaProdutoGateway categoriaProdutoGateway) {
        this.categoriaProdutoGateway = categoriaProdutoGateway;
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
