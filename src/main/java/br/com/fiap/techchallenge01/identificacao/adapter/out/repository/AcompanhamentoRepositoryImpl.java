package br.com.fiap.techchallenge01.identificacao.adapter.out.repository;

import br.com.fiap.techchallenge01.identificacao.adapter.out.exception.AcompanhamentoNaoEncontradoException;
import br.com.fiap.techchallenge01.identificacao.domain.Acompanhamento;
import br.com.fiap.techchallenge01.identificacao.domain.repository.AcompanhamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AcompanhamentoRepositoryImpl implements AcompanhamentoRepository {

    @Autowired
    private JpaAcompanhamentoRepository jpaAcompanhamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Acompanhamento salvarAcompanhamento(Acompanhamento usuario) {
        return null;
    }

    @Override
    public Optional<Acompanhamento> buscarAcompanhamentoPorId(Long id) {

        return jpaAcompanhamentoRepository.findById(id)
                .map(jpaAcompanhamentoEntity -> modelMapper.map(jpaAcompanhamentoEntity, Acompanhamento.class));

    }

    @Override
    public List<Acompanhamento> buscarAcompanhamentos() {
        return jpaAcompanhamentoRepository.findAll()
                .stream()
                .map(jpaAcompanhamentoEntity -> modelMapper.map(jpaAcompanhamentoEntity, Acompanhamento.class))
                .collect(Collectors.toList());
    }
}
