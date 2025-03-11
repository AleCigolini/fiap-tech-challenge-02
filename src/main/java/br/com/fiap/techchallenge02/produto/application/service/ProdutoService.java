package br.com.fiap.techchallenge02.produto.application.service;

import br.com.fiap.techchallenge02.produto.adapter.out.port.ProdutoRepository;
import br.com.fiap.techchallenge02.produto.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutos() {
        return produtoRepository.buscarProdutos();
    }

    @Override
    @Transactional(readOnly = true)
    public Produto buscarProdutoPorId(String id) {
        return produtoRepository.buscarProdutoPorId(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.criarProduto(produto);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.atualizarProduto(produto);
    }

    @Override
    public void excluirProduto(String idProduto) {
        produtoRepository.excluirProduto(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        return produtoRepository.buscarProdutosPorCategoria(idCategoriaProduto);
    }
}

