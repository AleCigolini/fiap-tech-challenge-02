package br.com.fiap.techchallenge01.cliente.adapter.out.repository;


import br.com.fiap.techchallenge01.cliente.adapter.out.entity.JpaClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaClienteRepository extends JpaRepository<JpaClienteEntity, UUID> {
    List<JpaClienteEntity> findByCpf(String cpf);
}
