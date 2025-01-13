package br.com.fiap.techchallenge01.cliente.application.exception;

import br.com.fiap.techchallenge01.core.config.exception.exceptions.NegocioException;

public class ClienteValidacaoException extends NegocioException {

    public ClienteValidacaoException(String mensagem) {
        super(mensagem);
    }

}
