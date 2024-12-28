package br.com.fiap.techchallenge01.identificacao.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoriaProdutoRequestDTO {

    @Schema(description = "Nome do acompanhamento", example = "Nome do Acompanhamento", maxLength = 40)
    private String nome;

}