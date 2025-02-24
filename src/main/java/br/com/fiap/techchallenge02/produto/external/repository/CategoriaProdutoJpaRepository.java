package br.com.fiap.techchallenge02.produto.external.repository;

import br.com.fiap.techchallenge02.produto.external.entity.JpaCategoriaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaProdutoJpaRepository extends JpaRepository<JpaCategoriaProdutoEntity, UUID> {
}
