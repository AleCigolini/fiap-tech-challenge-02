package br.com.fiap.techchallenge01.identificacao.application.usecase;

import br.com.fiap.techchallenge01.identificacao.domain.Acompanhamento;

import java.util.List;

public interface AcompanhamentoUseCase {

    Acompanhamento salvarAcompanhamento(Acompanhamento usuario);
    Acompanhamento buscarAcompanhamentoPorId(Long id);
    List<Acompanhamento> buscarAcompanhamentos();
}
