package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PedidoResponseDTO {

    @Schema(description = "Identificador único do pedido", example = "e389406d-5531-4acf-a354-be5cc46a8cb1")
    private String id;

    @Schema(description = "Código do pedido")
    private String codigo;

    @Schema(description = "Valor total do pedido")
    private Double preco;

    @Schema(description = "Itens do pedido (Lanche, Acompanhamento, Bebida, Sobremesa)")
    private List<ProdutoResponseDTO> produtos;
}