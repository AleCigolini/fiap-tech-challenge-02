package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaProdutoRepository extends JpaRepository<JpaProdutoEntity, UUID> {

//    List<JpaProdutoEntity> findAllByIdCategoriaOrderByNomeAsc(UUID idCategoriaProduto);

    List<JpaProdutoEntity> findAllByOrderByNomeAsc();
}
