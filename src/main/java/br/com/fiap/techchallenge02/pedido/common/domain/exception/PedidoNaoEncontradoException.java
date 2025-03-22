package br.com.fiap.techchallenge02.pedido.common.domain.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.EntidadeNaoEncontradaException;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public PedidoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
