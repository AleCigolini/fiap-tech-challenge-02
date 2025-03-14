package br.com.fiap.techchallenge02.produto.application.usecase.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge02.produto.common.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutos() {
        return produtoGateway.buscarProdutos();
    }

    @Override
    @Transactional(readOnly = true)
    public Produto buscarProdutoPorId(String id) {
        return produtoGateway.buscarProdutoPorId(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoGateway.criarProduto(produto);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoGateway.atualizarProduto(produto);
    }

    @Override
    public void excluirProduto(String idProduto) {
        produtoGateway.excluirProduto(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        return produtoGateway.buscarProdutosPorCategoria(idCategoriaProduto);
    }
}

