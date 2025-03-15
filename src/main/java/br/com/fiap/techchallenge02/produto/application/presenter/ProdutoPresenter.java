package br.com.fiap.techchallenge02.produto.application.presenter;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.common.dto.response.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoPresenter {

    List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos);

    ProdutoResponseDTO produtoParaProdutoResponseDTO(Produto produto);
}
