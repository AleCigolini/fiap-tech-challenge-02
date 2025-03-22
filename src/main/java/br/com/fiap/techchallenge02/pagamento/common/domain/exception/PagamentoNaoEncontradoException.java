package br.com.fiap.techchallenge02.pagamento.common.domain.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.EntidadeNaoEncontradaException;

public class PagamentoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public PagamentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}