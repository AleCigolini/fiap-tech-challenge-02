package br.com.fiap.techchallenge02.produto.application.usecase;

import br.com.fiap.techchallenge02.produto.domain.Produto;

import java.util.List;

public interface ProdutoUseCase {

    List<Produto> buscarProdutos();

//    ProdutoResponseDTO buscarProdutoPorId(String id);
//
//    ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO);
//
//    ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String idProduto);
//
//    void excluirProduto(String idProduto);
//
//    List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto);
}
