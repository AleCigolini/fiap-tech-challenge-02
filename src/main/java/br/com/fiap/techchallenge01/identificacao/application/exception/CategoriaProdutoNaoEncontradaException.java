package br.com.fiap.techchallenge01.identificacao.application.exception;

import br.com.fiap.techchallenge01.core.config.exception.exceptions.EntidadeNaoEncontradaException;

public class CategoriaProdutoNaoEncontradaException extends EntidadeNaoEncontradaException {

    public CategoriaProdutoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CategoriaProdutoNaoEncontradaException(Long categoriaProdutoId) {
        this(String.format("Não existe a categoria do produto para id: %d", categoriaProdutoId));
    }

}
