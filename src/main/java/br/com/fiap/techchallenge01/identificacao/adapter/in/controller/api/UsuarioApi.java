package br.com.fiap.techchallenge01.identificacao.adapter.in.controller.api;

import br.com.fiap.techchallenge01.identificacao.domain.Usuario;
import br.com.fiap.techchallenge01.identificacao.domain.dto.request.UsuarioRequestDto;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.UsuarioResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "API de usuários")
public interface UsuarioApi {
    /**
     * Busca o usuário a partir de seu ID.
     * @return {@link UsuarioResponseDto}
     */
    @Operation(summary = "Buscar usuário com Id")
    ResponseEntity<UsuarioResponseDto> buscarUsuario(UUID id);
    /**
     * Cadastrar o usuárioo
     * @return {@link UsuarioResponseDto}
     */
    @Operation(summary = "Cadastro do usuário")
    ResponseEntity<UsuarioResponseDto> cadastrarUsuario(UsuarioRequestDto usuarioRequestDto);
}
