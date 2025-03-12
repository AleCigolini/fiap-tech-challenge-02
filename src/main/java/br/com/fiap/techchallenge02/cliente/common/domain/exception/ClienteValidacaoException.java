package br.com.fiap.techchallenge02.cliente.common.domain.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.NegocioException;

public class ClienteValidacaoException extends NegocioException {

    public ClienteValidacaoException(String mensagem) {
        super(mensagem);
    }

}
