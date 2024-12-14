package br.com.fiap.techchallenge01.identificacao.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioResponseDto {
    @Schema(description = "Identificador único do usuário", example = "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa")
    private UUID id;
    @Schema(description = "E-mail do usuário", example = "teste@email.com")
    private String email;
}
