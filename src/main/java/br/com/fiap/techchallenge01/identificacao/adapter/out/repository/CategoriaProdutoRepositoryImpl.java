package br.com.fiap.techchallenge01.identificacao.adapter.out.repository;

import br.com.fiap.techchallenge01.identificacao.adapter.out.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge01.identificacao.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.identificacao.domain.repository.CategoriaProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoriaProdutoRepositoryImpl implements CategoriaProdutoRepository {

    @Autowired
    private JpaCategoriaProdutoRepository jpaCategoriaProdutoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto) {

        JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity = modelMapper.map(categoriaProduto, JpaCategoriaProdutoEntity.class);

        return modelMapper.map(jpaCategoriaProdutoRepository.save(jpaCategoriaProdutoEntity), CategoriaProduto.class);
    }

    @Override
    public Optional<CategoriaProduto> buscarCategoriaProdutoPorId(Long id) {

        return jpaCategoriaProdutoRepository.findById(id)
                .map(jpaAcompanhamentoEntity -> modelMapper.map(jpaAcompanhamentoEntity, CategoriaProduto.class));

    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return jpaCategoriaProdutoRepository.findByAtivoTrue()
                .stream()
                .map(jpaAcompanhamentoEntity -> modelMapper.map(jpaAcompanhamentoEntity, CategoriaProduto.class))
                .collect(Collectors.toList());
    }
}
