package br.com.fiap.techchallenge01.usuario.domain.repository;

import br.com.fiap.techchallenge01.usuario.domain.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario salvarUsuario(Usuario usuario);
    List<Usuario> buscarUsuarioPorCpf(String cpf);
}
