package br.com.fiap.techchallenge02.produto.adapter.presenter;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.external.entity.JpaProdutoEntity;

import java.util.List;

public interface ProdutoPresenter {

    List<Produto> jpaProdutoEntitiesParaProdutos(List<JpaProdutoEntity> jpaProdutoEntities);

    Produto jpaProdutoEntityParaProduto(JpaProdutoEntity jpaProdutoEntity);

    List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos);

    ProdutoResponseDTO produtoParaProdutoResponseDTO(Produto produto);

    Produto produtoRequestDtoParaProduto(ProdutoRequestDTO produtoRequestDTO);

    JpaProdutoEntity produtoParaJpaProdutoEntity(Produto produto);
}
