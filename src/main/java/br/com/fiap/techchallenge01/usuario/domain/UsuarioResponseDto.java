package br.com.fiap.techchallenge01.usuario.domain;

import lombok.Data;

@Data
public class UsuarioResponseDto {
    private String nome;
    private String email;

    private String cpf;
}
