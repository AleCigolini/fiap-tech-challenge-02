package br.com.fiap.techchallenge02.produto.infrastructure.database.adpater;

import br.com.fiap.techchallenge02.produto.common.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.common.entity.JpaProdutoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoDatabase {
    List<JpaProdutoEntity> findAllByOrderByNomeAsc();
    List<JpaProdutoEntity> findAllByCategoriaOrderByNomeAsc(JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity);
    Optional<JpaProdutoEntity> findById(UUID uuid);
    JpaProdutoEntity save(JpaProdutoEntity jpaProdutoEntity);
    void deleteById(UUID uuid);

}
