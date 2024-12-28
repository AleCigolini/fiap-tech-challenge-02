package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProdutoRepository extends JpaRepository<JpaProdutoEntity, Long> {
}
