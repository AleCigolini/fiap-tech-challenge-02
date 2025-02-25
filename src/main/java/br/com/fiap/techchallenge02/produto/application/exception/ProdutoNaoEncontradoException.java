package br.com.fiap.techchallenge02.produto.application.exception;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.EntidadeNaoEncontradaException;

import java.io.Serial;
import java.util.UUID;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradoException(UUID idProduto) {
        this("Não existe um produto com ID:" + idProduto);
    }

}
