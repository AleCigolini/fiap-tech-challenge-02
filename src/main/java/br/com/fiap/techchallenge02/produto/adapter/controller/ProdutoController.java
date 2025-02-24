package br.com.fiap.techchallenge02.produto.adapter.controller;

import br.com.fiap.techchallenge02.produto.adapter.presenter.ProdutoPresenter;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;
    private final ProdutoPresenter produtoPresenter;
    private final CategoriaProdutoController categoriaProdutoController;

    public List<ProdutoResponseDTO> buscarProdutos() {
        List<Produto> produtos = produtoUseCase.buscarProdutos();

        return produtoPresenter.produtosParaProdutosResponseDTO(produtos);
    }

    public List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto) {
        List<Produto> produtos = produtoUseCase.buscarProdutosPorCategoria(idCategoriaProduto);

        return produtoPresenter.produtosParaProdutosResponseDTO(produtos);
    }

    public ProdutoResponseDTO buscarProdutoPorId(String id) {
        Produto produto = produtoUseCase.buscarProdutoPorId(id);

        return produtoPresenter.produtoParaProdutoResponseDTO(produto);
    }

    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoPresenter.produtoRequestDtoParaProduto(produtoRequestDTO);

        Produto produtoCriado = produtoUseCase.criarProduto(produto);
        CategoriaProduto categoriaProduto = categoriaProdutoController.buscarCategoriaProdutoPorId(produtoRequestDTO.getIdCategoria());

        ProdutoResponseDTO produtoResponseDTO = produtoPresenter.produtoParaProdutoResponseDTO(produtoCriado);
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }
}
