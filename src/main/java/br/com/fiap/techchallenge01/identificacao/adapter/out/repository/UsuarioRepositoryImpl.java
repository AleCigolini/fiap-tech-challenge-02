package br.com.fiap.techchallenge01.identificacao.adapter.out.repository;

import br.com.fiap.techchallenge01.identificacao.adapter.out.entity.JpaUsuarioEntity;
import br.com.fiap.techchallenge01.identificacao.domain.Usuario;
import br.com.fiap.techchallenge01.identificacao.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final JpaUsuarioRepository jpaUsuarioRepository;
    private final ModelMapper usuarioMapper;

    public UsuarioRepositoryImpl(
            JpaUsuarioRepository jpaUsuarioRepository,
            @Qualifier("usuarioMapper") ModelMapper usuarioMapper) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        JpaUsuarioEntity jpaUsuarioEntity = new JpaUsuarioEntity(usuario);
        jpaUsuarioRepository.save(jpaUsuarioEntity);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscaUsuario(UUID id) {
        final var usuarioJpa = jpaUsuarioRepository.findById(id);
        return usuarioJpa.map(usuario -> usuarioMapper.map(usuario, Usuario.class));
    }
}
