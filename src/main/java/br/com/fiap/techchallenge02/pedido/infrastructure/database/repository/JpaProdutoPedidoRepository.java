package br.com.fiap.techchallenge02.pedido.infrastructure.database.repository;

import br.com.fiap.techchallenge02.pedido.common.domain.entity.JpaProdutoPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProdutoPedidoRepository extends JpaRepository<JpaProdutoPedidoEntity, Long> {

}