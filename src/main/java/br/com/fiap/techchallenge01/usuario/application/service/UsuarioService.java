package br.com.fiap.techchallenge01.usuario.application.service;

import br.com.fiap.techchallenge01.usuario.application.usecase.UsuarioUseCase;
import br.com.fiap.techchallenge01.usuario.domain.Usuario;
import br.com.fiap.techchallenge01.usuario.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements UsuarioUseCase {
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.salvarUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorCpf(String cpf) {
        List<Usuario> usuariosEncontradosPorCpf = usuarioRepository.buscarUsuarioPorCpf(cpf);
        validarUsuariosEncontradosPorCpf(usuariosEncontradosPorCpf);
        return usuariosEncontradosPorCpf.getFirst();
    }

    private void validarUsuariosEncontradosPorCpf(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        if (usuarios.size() > 1) {
            throw new RuntimeException("Mais de um usuário encontrado");
        }
    }
}
