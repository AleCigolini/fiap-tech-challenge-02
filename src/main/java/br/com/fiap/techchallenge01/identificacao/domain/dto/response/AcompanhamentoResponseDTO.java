package br.com.fiap.techchallenge01.identificacao.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AcompanhamentoResponseDTO {

    @Schema(description = "Identificador único do acompanhamento", example = "1")
    private Long id;

    @Schema(description = "Nome do acompanhamento", example = "Nome do Acompanhamento", maxLength = 40)
    private String nome;

}