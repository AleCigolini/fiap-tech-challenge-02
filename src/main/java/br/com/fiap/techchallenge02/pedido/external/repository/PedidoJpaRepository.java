package br.com.fiap.techchallenge02.pedido.external.repository;

import br.com.fiap.techchallenge02.pedido.external.entity.JpaPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PedidoJpaRepository extends JpaRepository<JpaPedidoEntity, UUID> {

    @Query(value = "SELECT e FROM JpaPedidoEntity e " +
            "WHERE e.status IN :status " +
            "ORDER BY CASE e.status " +
            "WHEN 'APROVADO' THEN 1 " +
            "WHEN 'EM_ANDAMENTO' THEN 2 " +
            "WHEN 'ENTREGUE' THEN 3 " +
            "ELSE 4 END ASC, e.dataCriacao ASC")
    List<JpaPedidoEntity> findAllByStatusIn(@Param("status") List<String> status);
}
