package br.com.fiap.techchallenge01.pedido.adapter.out.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaProdutoPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProdutoPedidoRepository extends JpaRepository<JpaProdutoPedidoEntity, Long> {

}
