package br.com.fiap.techchallenge02.produto.adapter.controller;

import br.com.fiap.techchallenge02.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoriaProdutoController {

    private final CategoriaProdutoUseCase categoriaProdutoUseCase;

    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
    }

}
