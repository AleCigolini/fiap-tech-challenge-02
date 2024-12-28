package br.com.fiap.techchallenge01.produto.application.service;

import br.com.fiap.techchallenge01.produto.adapter.out.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge01.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public List<Produto> buscarProdutos() {
        return produtoRepository.buscarProdutos();
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.buscarProdutoPorId(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }
}
