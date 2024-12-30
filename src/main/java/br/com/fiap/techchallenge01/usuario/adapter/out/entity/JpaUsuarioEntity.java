package br.com.fiap.techchallenge01.usuario.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JpaUsuarioEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 60, name = "primeiro_nome")
    private String primeiroNome;

    @Column(length = 60)
    private String sobrenome;

    @Column(unique = true, length = 254)
    private String email;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String senha;
}
