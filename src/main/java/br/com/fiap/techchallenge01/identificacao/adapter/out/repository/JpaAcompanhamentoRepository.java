package br.com.fiap.techchallenge01.identificacao.adapter.out.repository;

import br.com.fiap.techchallenge01.identificacao.adapter.out.entity.JpaAcompanhamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaAcompanhamentoRepository extends JpaRepository<JpaAcompanhamentoEntity, Long> {
}
