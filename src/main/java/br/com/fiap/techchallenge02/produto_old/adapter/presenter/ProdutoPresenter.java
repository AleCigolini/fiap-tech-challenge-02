package br.com.fiap.techchallenge02.produto_old.adapter.presenter;

import br.com.fiap.techchallenge02.produto_old.domain.Produto;
import br.com.fiap.techchallenge02.produto_old.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto_old.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto_old.external.entity.JpaProdutoEntity;

import java.util.List;

public interface ProdutoPresenter {

    List<Produto> jpaProdutoEntitiesParaProdutos(List<JpaProdutoEntity> jpaProdutoEntities);

    Produto jpaProdutoEntityParaProduto(JpaProdutoEntity jpaProdutoEntity);

    List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos);

    ProdutoResponseDTO produtoParaProdutoResponseDTO(Produto produto);

    Produto produtoRequestDtoParaProduto(ProdutoRequestDTO produtoRequestDTO);

    JpaProdutoEntity produtoParaJpaProdutoEntity(Produto produto);
}
