package br.com.fiap.techchallenge01.usuario.adapter.out.repository;

import br.com.fiap.techchallenge01.usuario.adapter.out.entity.JpaUsuarioEntity;
import br.com.fiap.techchallenge01.usuario.domain.Usuario;
import br.com.fiap.techchallenge01.usuario.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        JpaUsuarioEntity jpaUsuarioEntity = modelMapper.map(usuario, JpaUsuarioEntity.class);
        return modelMapper.map(jpaUsuarioRepository.save(jpaUsuarioEntity), Usuario.class);
    }

    @Override
    public List<Usuario> buscarUsuarioPorCpf(String cpf) {
        return jpaUsuarioRepository.findByCpf(cpf)
                .stream()
                .map(jpaUsuarioEntity -> modelMapper.map(jpaUsuarioEntity, Usuario.class))
                .collect(Collectors.toList());
    }
}
