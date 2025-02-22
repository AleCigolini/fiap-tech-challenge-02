package br.com.fiap.techchallenge02.produto.adapter.presenter;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.external.entity.JpaProdutoEntity;

import java.util.List;

public interface ProdutoPresenter {

    List<Produto> jpaProdutoEntityParaProduto(List<JpaProdutoEntity> jpaProdutoEntities);

    List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos);
}
