package br.com.fiap.techchallenge01.identificacao.utils.mapper;

import br.com.fiap.techchallenge01.identificacao.adapter.out.entity.JpaUsuarioEntity;
import br.com.fiap.techchallenge01.identificacao.domain.Usuario;
import br.com.fiap.techchallenge01.identificacao.domain.dto.request.UsuarioRequestDto;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioMapper {
    @Bean
    public ModelMapper usuarioMapper() {
        var modelMapper = new ModelMapper();
        jpaUsuarioEntityToUsuario(modelMapper);
        usuarioRequestDtoToUsuario(modelMapper);
        usuarioToUsuarioResponseDto(modelMapper);
        return modelMapper;

    }

    private void jpaUsuarioEntityToUsuario(ModelMapper modelMapper) {
        modelMapper.createTypeMap(JpaUsuarioEntity.class, Usuario.class);
    }

    private void usuarioRequestDtoToUsuario(ModelMapper modelMapper) {
        modelMapper.createTypeMap(UsuarioRequestDto.class, Usuario.class);
    }

    private void usuarioToUsuarioResponseDto(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Usuario.class, UsuarioResponseDto.class);
    }
}
