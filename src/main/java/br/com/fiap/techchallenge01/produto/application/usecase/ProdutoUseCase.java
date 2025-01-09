package br.com.fiap.techchallenge01.produto.application.usecase;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoUseCase {

    List<ProdutoResponseDTO> buscarProdutos();

    ProdutoResponseDTO buscarProdutoPorId(String id);

    Produto obterProdutoPorId(String id);

    ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO);

    ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String idProduto);

    void excluirProduto(String idProduto);

    List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto);
}
