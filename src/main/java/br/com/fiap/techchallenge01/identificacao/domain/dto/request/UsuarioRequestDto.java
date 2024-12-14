package br.com.fiap.techchallenge01.identificacao.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioRequestDto {
    @Schema(description = "E-mail do usuário", example = "teste@email.com")
    private String email;
}
