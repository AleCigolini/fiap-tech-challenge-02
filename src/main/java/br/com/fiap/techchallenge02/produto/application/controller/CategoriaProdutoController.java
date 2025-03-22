package br.com.fiap.techchallenge02.produto.application.controller;

import br.com.fiap.techchallenge02.produto.common.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.common.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoController {
    CategoriaProduto buscarCategoriaProdutoPorId(String id);

    List<CategoriaProdutoResponseDTO> buscarCategoriasProduto();

    CategoriaProdutoResponseDTO criarCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDto);

}
