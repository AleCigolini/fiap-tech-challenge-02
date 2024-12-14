package br.com.fiap.techchallenge01.identificacao.application.usecase;

import br.com.fiap.techchallenge01.identificacao.domain.Usuario;

import java.util.UUID;

public interface UsuarioUseCase {
    Usuario criarUsuario(Usuario usuario);
    Usuario buscarUsuario(UUID id);
}
