package br.com.fiap.techchallenge01.identificacao.domain.repository;

import br.com.fiap.techchallenge01.identificacao.domain.Acompanhamento;

import java.util.List;
import java.util.Optional;

public interface AcompanhamentoRepository {

    Acompanhamento salvarAcompanhamento(Acompanhamento acompanhamento);
    Optional<Acompanhamento> buscarAcompanhamentoPorId(Long id);
    List<Acompanhamento> buscarAcompanhamentos();
}
