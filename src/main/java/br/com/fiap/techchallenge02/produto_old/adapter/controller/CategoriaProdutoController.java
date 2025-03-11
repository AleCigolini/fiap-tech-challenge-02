package br.com.fiap.techchallenge02.produto_old.adapter.controller;

import br.com.fiap.techchallenge02.produto_old.adapter.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto_old.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto_old.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto_old.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto_old.domain.dto.response.CategoriaProdutoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaProdutoController {

    private final CategoriaProdutoUseCase categoriaProdutoUseCase;
    private final CategoriaProdutoPresenter categoriaProdutoPresenter;

    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
    }

    public CategoriaProdutoResponseDTO buscarCategoriaProdutoResponseDTOPorId(String id) {
        CategoriaProduto categoriaProduto = categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);

        return categoriaProdutoPresenter.categoriaProdutoParaCategoriaProdutoResponseDTO(categoriaProduto);
    }

    public List<CategoriaProdutoResponseDTO> buscarCategoriasProduto() {
        List<CategoriaProduto> categoriaProdutos = categoriaProdutoUseCase.buscarCategoriasProduto();

        return categoriaProdutoPresenter.categoriasProdutoParaCategoriasProdutoResponseDTO(categoriaProdutos);
    }

    public CategoriaProdutoResponseDTO criarCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDto) {
        CategoriaProduto categoriaProduto = categoriaProdutoPresenter.categoriaProdutoRequestDTOParaCategoriaProduto(categoriaProdutoRequestDto);
        CategoriaProduto categoriaProdutoCriado = categoriaProdutoUseCase.criarCategoriaProduto(categoriaProduto);

        return categoriaProdutoPresenter.categoriaProdutoParaCategoriaProdutoResponseDTO(categoriaProdutoCriado);
    }
}
