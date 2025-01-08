package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PedidoProdutoCategoriaResponseDTO {

    @Schema(description = "Nome da categoria")
    private String nome;
}