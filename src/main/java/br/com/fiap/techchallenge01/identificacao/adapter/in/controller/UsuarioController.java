package br.com.fiap.techchallenge01.identificacao.adapter.in.controller;

import br.com.fiap.techchallenge01.identificacao.adapter.in.controller.api.UsuarioApi;
import br.com.fiap.techchallenge01.identificacao.adapter.out.repository.JpaUsuarioRepository;
import br.com.fiap.techchallenge01.identificacao.application.service.UsuarioService;
import br.com.fiap.techchallenge01.identificacao.domain.Usuario;
import br.com.fiap.techchallenge01.identificacao.domain.dto.request.UsuarioRequestDto;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.UsuarioResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements UsuarioApi {
    private final UsuarioService usuarioService;
    private final ModelMapper usuarioMapper;

    public UsuarioController(
            UsuarioService usuarioService,
            @Qualifier("usuarioMapper") ModelMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<UsuarioResponseDto> buscarUsuario(UUID id) {
        final Usuario usuario = this.usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(usuarioMapper.map(usuario, UsuarioResponseDto.class));
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(UsuarioRequestDto usuarioRequestDto) {
        final Usuario usuarioRequest = usuarioMapper.map(usuarioRequestDto, Usuario.class);
        final Usuario usuario = this.usuarioService.criarUsuario(usuarioRequest);
        return ResponseEntity.ok(usuarioMapper.map(usuario, UsuarioResponseDto.class));
    }

}
