package br.com.fiap.techchallenge02.produto_old.application.usecase;

import br.com.fiap.techchallenge02.produto_old.adapter.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto_old.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge02.produto_old.domain.Produto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoGateway.buscarProdutos();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        return produtoGateway.buscarProdutosPorCategoria(idCategoriaProduto);
    }

    @Override
    public Produto buscarProdutoPorId(String id) {
        Produto produto = produtoGateway.buscarProdutoPorId(id);

        if (produto == null) {
            throw new ProdutoNaoEncontradoException(UUID.fromString(id));
        }

        return produto;
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
}
