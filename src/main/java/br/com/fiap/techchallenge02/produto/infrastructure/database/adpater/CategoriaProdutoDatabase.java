package br.com.fiap.techchallenge02.produto.infrastructure.database.adpater;

import br.com.fiap.techchallenge02.produto.common.entity.JpaCategoriaProdutoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaProdutoDatabase {

    JpaCategoriaProdutoEntity save(JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity);

    Optional<JpaCategoriaProdutoEntity> findById(UUID uuid);

    List<JpaCategoriaProdutoEntity> findAllByAtivoTrue();
}
