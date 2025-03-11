package br.com.fiap.techchallenge02.produto_old.external.repository;

import br.com.fiap.techchallenge02.produto_old.external.entity.JpaCategoriaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoriaProdutoJpaRepository extends JpaRepository<JpaCategoriaProdutoEntity, UUID> {

    List<JpaCategoriaProdutoEntity> findByAtivoTrue();
}
