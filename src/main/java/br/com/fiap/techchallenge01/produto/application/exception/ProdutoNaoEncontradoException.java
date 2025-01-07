package br.com.fiap.techchallenge01.produto.application.exception;


import br.com.fiap.techchallenge01.identificacao.application.exception.EntidadeNaoEncontradaException;

import static java.lang.StringTemplate.STR;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradoException(Long idProduto) {
        this(STR."Não existe um produto com ID: \{idProduto}");
    }

}
