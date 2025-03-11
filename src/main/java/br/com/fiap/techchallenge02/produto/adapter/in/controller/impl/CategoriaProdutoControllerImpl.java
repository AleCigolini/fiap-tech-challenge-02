package br.com.fiap.techchallenge02.produto.adapter.in.controller.impl;

import br.com.fiap.techchallenge02.produto.adapter.in.config.mapper.CategoriaProdutoMapper;
import br.com.fiap.techchallenge02.produto.adapter.in.config.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto.adapter.in.controller.CategoriaProdutoController;
import br.com.fiap.techchallenge02.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.response.CategoriaProdutoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaProdutoControllerImpl implements CategoriaProdutoController {

    private final CategoriaProdutoUseCase categoriaProdutoUseCase;
    private final CategoriaProdutoPresenter categoriaProdutoPresenter;
    private final CategoriaProdutoMapper categoriaProdutoMapper;

    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
    }

    public List<CategoriaProdutoResponseDTO> buscarCategoriasProduto() {
        List<CategoriaProduto> categoriaProdutos = categoriaProdutoUseCase.buscarCategoriasProduto();

        return categoriaProdutoPresenter.categoriasProdutoParaCategoriasProdutoResponseDTO(categoriaProdutos);
    }

    @Override
    public CategoriaProdutoResponseDTO criarCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoMapper.categoriaProdutoRequestDTOParaCategoriaProduto(categoriaProdutoRequestDTO);
        CategoriaProduto categoriaProdutoCriado = categoriaProdutoUseCase.salvarCategoriaProduto(categoriaProduto);

        return categoriaProdutoPresenter.categoriaProdutoParaCategoriaProdutoResponseDTO(categoriaProdutoCriado);
    }
}
