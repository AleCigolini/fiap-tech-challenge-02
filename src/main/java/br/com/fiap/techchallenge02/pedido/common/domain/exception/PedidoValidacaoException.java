package br.com.fiap.techchallenge02.pedido.common.domain.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.NegocioException;

public class PedidoValidacaoException extends NegocioException {

    public PedidoValidacaoException(String mensagem) {
        super(mensagem);
    }
}