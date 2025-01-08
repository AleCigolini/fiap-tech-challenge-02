package br.com.fiap.techchallenge01.produto.application.usecase;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoUseCase {

    List<ProdutoResponseDTO> buscarProdutos();

    Produto buscarProdutoPorId(Long id);

    ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO);

    ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, Long idProduto);

    void excluirProduto(Long idProduto);

    List<ProdutoResponseDTO> buscarProdutosPorCategoria(Long idCategoriaProduto);
}
