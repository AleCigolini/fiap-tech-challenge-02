package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaCategoriaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCategoriaProdutoRepository extends JpaRepository<JpaCategoriaProdutoEntity, Long> {

    List<JpaCategoriaProdutoEntity> findByAtivoTrue();
}
