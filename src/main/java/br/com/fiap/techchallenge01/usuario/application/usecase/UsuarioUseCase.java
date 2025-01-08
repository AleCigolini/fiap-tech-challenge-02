package br.com.fiap.techchallenge01.usuario.application.usecase;

import br.com.fiap.techchallenge01.usuario.domain.Usuario;

public interface UsuarioUseCase {
    Usuario salvarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorCpf(String cpf);
}
