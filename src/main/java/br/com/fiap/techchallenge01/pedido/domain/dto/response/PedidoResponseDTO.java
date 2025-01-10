package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class PedidoResponseDTO {

    @Schema(description = "Identificador único do pedido", example = "e389406d-5531-4acf-a354-be5cc46a8cb1")
    private String id;

    @Schema(description = "Código do pedido")
    private String codigo;

    @Schema(description = "Valor total do pedido")
    private Double preco;

    @Schema(description = "Data de criação do pedido", example = "2023-01-01T10:00:00Z")
    private OffsetDateTime dataCriacao;

    @Schema(description = "Produtos do pedido")
    private List<ProdutoPedidoResponseDTO> produtos;
}