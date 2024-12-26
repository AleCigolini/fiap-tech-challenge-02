package br.com.fiap.techchallenge01.identificacao.adapter.out.exception;

public class AcompanhamentoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public AcompanhamentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AcompanhamentoNaoEncontradoException(Long acompanhamentoId) {
		this(String.format("Não existe um cadastro de acompanhamento com código %d", acompanhamentoId));
	}
	
}
