package br.com.fiap.techchallenge01.pedido.adapter.out.repository;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPagamentoEntity;
import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPagamentoRepository extends JpaRepository<JpaPagamentoEntity, Long> {

}
