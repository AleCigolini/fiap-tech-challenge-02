package br.com.fiap.techchallenge02.produto.application.gateway.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.mapper.CategoriaProdutoMapper;
import br.com.fiap.techchallenge02.produto.common.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.infrastructure.database.adpater.CategoriaProdutoDatabase;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CategoriaProdutoGatewayImpl implements CategoriaProdutoGateway {

    private final CategoriaProdutoDatabase categoriaProdutoDatabase;
    private final CategoriaProdutoMapper categoriaProdutoMapper;

    public CategoriaProdutoGatewayImpl(CategoriaProdutoDatabase categoriaProdutoDatabase, CategoriaProdutoMapper categoriaProdutoMapper) {
        this.categoriaProdutoDatabase = categoriaProdutoDatabase;
        this.categoriaProdutoMapper = categoriaProdutoMapper;
    }

    @Override
    public CategoriaProduto salvarCategoriaProduto(CategoriaProduto categoriaProduto) {
        JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity = categoriaProdutoMapper.categoriaProdutoParaJpaCategoriaProdutoEntity(categoriaProduto);

        return categoriaProdutoMapper.jpaCategoriaProdutoEntityParaCategoriaProduto(categoriaProdutoDatabase.save(jpaCategoriaProdutoEntity));
    }

    @Override
    public Optional<CategoriaProduto> buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoDatabase.findById(UUID.fromString(id))
                .filter(JpaCategoriaProdutoEntity::getAtivo)
                .map(categoriaProdutoMapper::jpaCategoriaProdutoEntityParaCategoriaProduto);

    }

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        return categoriaProdutoDatabase.findAllByAtivoTrue()
                .stream()
                .map(categoriaProdutoMapper::jpaCategoriaProdutoEntityParaCategoriaProduto)
                .collect(Collectors.toList());
    }
}
