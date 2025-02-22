package br.com.fiap.techchallenge02.produto.external.repository;

import br.com.fiap.techchallenge02.produto.external.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.external.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoJpaRepository extends JpaRepository<JpaProdutoEntity, UUID> {

    List<JpaProdutoEntity> findAllByCategoriaOrderByNomeAsc(JpaCategoriaProdutoEntity categoria);

    List<JpaProdutoEntity> findAllByOrderByNomeAsc();
}
