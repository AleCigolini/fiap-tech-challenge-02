package br.com.fiap.techchallenge01.produto.application.service;

import br.com.fiap.techchallenge01.produto.application.exception.CategoriaProdutoNaoEncontradaException;
import br.com.fiap.techchallenge01.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.repository.CategoriaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProdutoService implements CategoriaProdutoUseCase {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @Override
    public CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto) {

        categoriaProduto.setAtivo(true);

        return categoriaProdutoRepository.salvarCategoriaProduto(categoriaProduto);
    }

    @Override
    public CategoriaProduto buscarCategoriaProdutoPorId(Long id) {
        return categoriaProdutoRepository.buscarCategoriaProdutoPorId(id).orElseThrow(() -> new CategoriaProdutoNaoEncontradaException(id));
    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return categoriaProdutoRepository.buscarCategoriasProduto();
    }

    @Override
    public CategoriaProduto alterarNomeCategoriaProduto(Long id, CategoriaProduto categoriaProduto) {
        return categoriaProdutoRepository.alterarNomeCategoriaProduto(id, categoriaProduto);
    }

    @Override
    public void desativarCategoriaProduto(CategoriaProduto categoriaProduto) {
        categoriaProduto.setAtivo(false);
        categoriaProdutoRepository.desativarCategoriaProduto(categoriaProduto);
    }
}
