package br.com.fiap.techchallenge01.cliente.application.exception;

import br.com.fiap.techchallenge01.config.exception.exceptions.EntidadeNaoEncontradaException;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
