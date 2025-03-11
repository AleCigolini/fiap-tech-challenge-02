package br.com.fiap.techchallenge02.produto.application.service;

import br.com.fiap.techchallenge02.produto.adapter.out.port.CategoriaProdutoRepository;
import br.com.fiap.techchallenge02.produto.application.exception.CategoriaProdutoNaoEncontradaException;
import br.com.fiap.techchallenge02.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProdutoService implements CategoriaProdutoUseCase {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @Override
    public CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto) {
        return categoriaProdutoRepository.salvarCategoriaProduto(categoriaProduto);
    }

    @Override
    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoRepository.buscarCategoriaProdutoPorId(id).orElseThrow(() -> new CategoriaProdutoNaoEncontradaException(id));
    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return categoriaProdutoRepository.buscarCategoriasProduto();
    }
}
