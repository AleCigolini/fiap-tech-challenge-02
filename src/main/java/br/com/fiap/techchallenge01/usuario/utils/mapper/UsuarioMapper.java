package br.com.fiap.techchallenge01.usuario.utils.mapper;

import br.com.fiap.techchallenge01.usuario.domain.Usuario;
import br.com.fiap.techchallenge01.usuario.domain.UsuarioRequestDto;
import br.com.fiap.techchallenge01.usuario.domain.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioResponseDto toResponse(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResponseDto.class);
    }

    public Usuario requestDtoToDomain(UsuarioRequestDto usuarioRequestDto) {
        return modelMapper.map(usuarioRequestDto, Usuario.class);
    }

}
