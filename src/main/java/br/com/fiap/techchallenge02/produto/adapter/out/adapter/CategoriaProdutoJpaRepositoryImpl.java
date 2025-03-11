package br.com.fiap.techchallenge02.produto.adapter.out.adapter;

import br.com.fiap.techchallenge02.produto.adapter.out.jpa.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.adapter.out.jpa.JpaCategoriaProdutoRepository;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.adapter.out.port.CategoriaProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CategoriaProdutoJpaRepositoryImpl implements CategoriaProdutoRepository {

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
    public Optional<CategoriaProduto> buscarCategoriaProdutoPorId(String id) {
        return jpaCategoriaProdutoRepository.findById(UUID.fromString(id))
                .filter(JpaCategoriaProdutoEntity::getAtivo)
                .map(jpaCategoriaProdutoEntity -> modelMapper.map(jpaCategoriaProdutoEntity, CategoriaProduto.class));

    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return jpaCategoriaProdutoRepository.findByAtivoTrue()
                .stream()
                .map(jpaCategoriaProdutoEntity -> modelMapper.map(jpaCategoriaProdutoEntity, CategoriaProduto.class))
                .collect(Collectors.toList());
    }
}
