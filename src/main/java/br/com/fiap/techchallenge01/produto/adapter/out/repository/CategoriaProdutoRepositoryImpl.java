package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.repository.CategoriaProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    @Override
    public CategoriaProduto alterarNomeCategoriaProduto(String id, CategoriaProduto categoriaProduto) {
        return salvarCategoriaProduto(categoriaProduto);
    }

    @Override
    public void desativarCategoriaProduto(CategoriaProduto categoriaProduto) {
        salvarCategoriaProduto(categoriaProduto);
    }
}
