package br.com.fiap.techchallenge01.identificacao.adapter.in.controller.api;

import br.com.fiap.techchallenge01.identificacao.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.CategoriaProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "API de categorias de produto")
public interface CategoriaProdutoApi {

    /**
     * Busca a categoria de produto a partir de seu ID.
     *
     * @param id Long da categoria de produto
     * @return {@link CategoriaProdutoResponseDTO}
     */
    @Operation(summary = "Buscar categoria de produto com Id")
    CategoriaProdutoResponseDTO buscarCategoriaProduto(Long id);

    /**
     * Listar todas as categorias de produto.
     *
     * @return Lista de {@link CategoriaProdutoResponseDTO}
     */
    @Operation(summary = "Listar todas as categorias de produto")
    List<CategoriaProdutoResponseDTO> listarCategoriasProduto();

    /**
     * Cadastrar uma nova categoria de produto.
     *
     * @param categoriaProdutoRequestDto Dados da categoria de produto
     * @return {@link CategoriaProdutoRequestDTO}
     */
    @Operation(summary = "Cadastro de categoria de produto")
    CategoriaProdutoResponseDTO cadastrarCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDto);

}