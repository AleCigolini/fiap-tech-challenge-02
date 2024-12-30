package br.com.fiap.techchallenge01.usuario.adapter.out.repository;


import br.com.fiap.techchallenge01.usuario.adapter.out.entity.JpaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaUsuarioRepository extends JpaRepository<JpaUsuarioEntity, UUID> {
    List<JpaUsuarioEntity> findByCpf(String cpf);
}
