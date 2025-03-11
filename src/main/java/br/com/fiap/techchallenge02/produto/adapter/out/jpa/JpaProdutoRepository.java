package br.com.fiap.techchallenge02.produto.adapter.out.jpa;

import br.com.fiap.techchallenge02.produto.adapter.out.jpa.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.adapter.out.jpa.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaProdutoRepository extends JpaRepository<JpaProdutoEntity, UUID> {

    List<JpaProdutoEntity> findAllByCategoriaOrderByNomeAsc(JpaCategoriaProdutoEntity categoria);

    List<JpaProdutoEntity> findAllByOrderByNomeAsc();
}
