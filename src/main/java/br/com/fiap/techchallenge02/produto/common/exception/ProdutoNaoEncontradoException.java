package br.com.fiap.techchallenge02.produto.common.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.EntidadeNaoEncontradaException;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradoException(Long idProduto) {
        this("Não existe um produto com ID:" + idProduto);
    }

}
