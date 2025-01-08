package br.com.fiap.techchallenge01.pedido.adapter.out.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPedidoRepository extends JpaRepository<JpaPedidoEntity, Long> {

    List<JpaPedidoEntity> findAllByIdCategoria(Long idCategoriaPedido);
}
