package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PedidoResponseDTO {

    @Schema(description = "Identificador único do pedido", example = "1")
    private Long id;

    @Schema(description = "Código do pedido")
    private String codigo;

    @Schema(description = "Valor total do pedido")
    private Double valor;

    @Schema(description = "Itens do pedido (Lanche, Acompanhamento, Bebida, Sobremesa)")
    private ArrayList<PedidoProdutoResponseDTO> itensPedido;

}