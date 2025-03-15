package br.com.fiap.techchallenge02.produto.infrastructure.database.repository;

import br.com.fiap.techchallenge02.produto.common.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.common.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaProdutoRepository extends JpaRepository<JpaProdutoEntity, UUID> {

    List<JpaProdutoEntity> findAllByCategoriaOrderByNomeAsc(JpaCategoriaProdutoEntity categoria);

    List<JpaProdutoEntity> findAllByOrderByNomeAsc();
}
