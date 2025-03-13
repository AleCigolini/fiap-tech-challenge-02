package br.com.fiap.techchallenge02.pagamento.infrastructure.database.repository;

import br.com.fiap.techchallenge02.pagamento.common.domain.entity.JpaPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaPagamentoRepository extends JpaRepository<JpaPagamentoEntity, UUID> {

    List<JpaPagamentoEntity> findByCodigoPedido(String codigoPedido);
}