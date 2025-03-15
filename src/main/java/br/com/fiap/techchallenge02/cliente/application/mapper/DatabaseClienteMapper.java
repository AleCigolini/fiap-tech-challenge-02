package br.com.fiap.techchallenge02.cliente.application.mapper;

import br.com.fiap.techchallenge02.cliente.common.domain.entity.JpaClienteEntity;
import br.com.fiap.techchallenge02.cliente.domain.Cliente;

public interface DatabaseClienteMapper {
    JpaClienteEntity toJpaClienteEntity(Cliente usuario);
    Cliente toCliente(JpaClienteEntity jpaClienteEntity);
}