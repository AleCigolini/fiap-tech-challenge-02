package br.com.fiap.techchallenge01.produto.adapter.out.exception;

import br.com.fiap.techchallenge01.identificacao.adapter.out.exception.EntidadeNaoEncontradaException;

public class CategoriaProdutoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public CategoriaProdutoNaoEncontradaException(Long idCategoriaProduto) {
        super(STR."Não existe uma categoria produto com ID: \{idCategoriaProduto}");
    }

}
