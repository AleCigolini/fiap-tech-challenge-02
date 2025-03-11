package br.com.fiap.techchallenge02.produto.adapter.out.jpa;

import br.com.fiap.techchallenge02.produto.adapter.out.jpa.entity.JpaCategoriaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaCategoriaProdutoRepository extends JpaRepository<JpaCategoriaProdutoEntity, UUID> {

    List<JpaCategoriaProdutoEntity> findByAtivoTrue();
}
