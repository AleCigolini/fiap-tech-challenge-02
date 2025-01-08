package br.com.fiap.techchallenge01.usuario.adapter.in.controller.api;

import br.com.fiap.techchallenge01.usuario.domain.UsuarioRequestDto;
import br.com.fiap.techchallenge01.usuario.domain.UsuarioResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "API de usuários")
public interface UsuarioApi {

    /**
     * Busca o usuário a partir de seu CPF.
     *
     * @param cpf String do cpf do usuário
     * @return {@link ResponseEntity<UsuarioResponseDto>}
     */
    @Operation(summary = "Buscar um usuário a partir de seu cpf")
    ResponseEntity<UsuarioResponseDto> buscarUsuarioPorCpf(String cpf);

    /**
     * Cadastrar um novo usuário.
     *
     * @param usuarioRequestDto objeto contendo os dados para cadastro do usuário
     * @return {@link ResponseEntity<UsuarioResponseDto>}
     */
    @Operation(summary = "Cadastrar usuário")
    ResponseEntity<UsuarioResponseDto> cadastrarUsuario(UsuarioRequestDto usuarioRequestDto);

}
