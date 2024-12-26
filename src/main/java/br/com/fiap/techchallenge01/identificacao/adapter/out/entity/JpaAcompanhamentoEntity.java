package br.com.fiap.techchallenge01.identificacao.adapter.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Acompanhamento")
public class JpaAcompanhamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acompanhamento_id")
    @SequenceGenerator(name = "seq_acompanhamento_id", sequenceName = "seq_acompanhamento_id", allocationSize = 1)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
}