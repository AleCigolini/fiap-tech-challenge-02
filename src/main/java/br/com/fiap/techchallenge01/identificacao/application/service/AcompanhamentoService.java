package br.com.fiap.techchallenge01.identificacao.application.service;

import br.com.fiap.techchallenge01.identificacao.adapter.out.exception.AcompanhamentoNaoEncontradoException;
import br.com.fiap.techchallenge01.identificacao.application.usecase.AcompanhamentoUseCase;
import br.com.fiap.techchallenge01.identificacao.domain.Acompanhamento;
import br.com.fiap.techchallenge01.identificacao.domain.repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoService implements AcompanhamentoUseCase {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @Override
    public Acompanhamento salvarAcompanhamento(Acompanhamento usuario) {
        return acompanhamentoRepository.salvarAcompanhamento(usuario);
    }

    @Override
    public Acompanhamento buscarAcompanhamentoPorId(Long id) {
        return acompanhamentoRepository.buscarAcompanhamentoPorId(id).orElseThrow(() -> new AcompanhamentoNaoEncontradoException(id));
    }

    @Override
    public List<Acompanhamento> buscarAcompanhamentos() {
        return acompanhamentoRepository.buscarAcompanhamentos();
    }
}
