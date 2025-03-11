package br.com.fiap.techchallenge02.produto.adapter.in.controller;

import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;

import java.util.List;

public interface ProdutoController {
    List<ProdutoResponseDTO> buscarProdutos();

    List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto);

    ProdutoResponseDTO buscarProdutoPorId(String id);

    ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO);

    ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String id);

    void excluirProduto(String idProduto);
}
