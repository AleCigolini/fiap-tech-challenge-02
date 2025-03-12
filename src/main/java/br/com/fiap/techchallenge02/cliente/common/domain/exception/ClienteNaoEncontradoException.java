package br.com.fiap.techchallenge02.cliente.common.domain.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.EntidadeNaoEncontradaException;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
