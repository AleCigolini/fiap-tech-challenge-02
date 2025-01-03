package br.com.fiap.techchallenge01.produto.application.service;

import br.com.fiap.techchallenge01.produto.adapter.out.exception.CategoriaProdutoNaoEncontradaException;
import br.com.fiap.techchallenge01.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.repository.CategoriaProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaProdutoService implements CategoriaProdutoUseCase {

    private final CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaProdutoService(CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaProduto buscarCategoriaProdutoPorId(Long idCategoriaProduto) {
        return categoriaProdutoRepository.buscarCategoriaProdutoPorId(idCategoriaProduto).orElseThrow(() -> new CategoriaProdutoNaoEncontradaException(idCategoriaProduto));
    }
}
