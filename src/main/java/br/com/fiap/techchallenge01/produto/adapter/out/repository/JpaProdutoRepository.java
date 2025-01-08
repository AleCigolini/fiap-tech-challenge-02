package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProdutoRepository extends JpaRepository<JpaProdutoEntity, Long> {

    List<JpaProdutoEntity> findAllByIdCategoriaOrderByNomeAsc(Long idCategoriaProduto);

    List<JpaProdutoEntity> findAllByOrderByNomeAsc();
}
