package br.com.fiap.techchallenge02.produto.adapter.in.config.presenter;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoPresenter {

    List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos);

    ProdutoResponseDTO produtoParaProdutoResponseDTO(Produto produto);
}
