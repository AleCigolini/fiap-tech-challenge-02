package br.com.fiap.techchallenge01.usuario.adapter.in.controller;

import br.com.fiap.techchallenge01.usuario.adapter.in.controller.api.UsuarioApi;
import br.com.fiap.techchallenge01.usuario.application.service.UsuarioService;
import br.com.fiap.techchallenge01.usuario.domain.Usuario;
import br.com.fiap.techchallenge01.usuario.domain.UsuarioRequestDto;
import br.com.fiap.techchallenge01.usuario.domain.UsuarioResponseDto;
import br.com.fiap.techchallenge01.usuario.utils.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController implements UsuarioApi {
    private UsuarioMapper usuarioMapper;
    private UsuarioService usuarioService;

    @Override
    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioResponseDto> buscarUsuarioPorCpf(@RequestParam String cpf) {
        final UsuarioResponseDto usuarioResponseDto = usuarioMapper.toResponse(usuarioService.buscarUsuarioPorCpf(cpf));
        return ResponseEntity.ok(usuarioResponseDto);
    }

    @Override
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        final Usuario usuario = usuarioService.salvarUsuario(usuarioMapper.requestDtoToDomain(usuarioRequestDto));
        return ResponseEntity.ok(usuarioMapper.toResponse(usuario));
    }

}
