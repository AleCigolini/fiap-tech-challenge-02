package br.com.fiap.techchallenge02.produto.adapter.controller;

import br.com.fiap.techchallenge02.produto.adapter.presenter.ProdutoPresenter;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;
    private final ProdutoPresenter produtoPresenter;

    public List<ProdutoResponseDTO> buscarProdutos() {
        List<Produto> produtos = produtoUseCase.buscarProdutos();

        return produtoPresenter.produtosParaProdutosResponseDTO(produtos);
    }
}
