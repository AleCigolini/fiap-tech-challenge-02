package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import br.com.fiap.techchallenge01.cliente.domain.dto.response.ClienteResponseDto;
import br.com.fiap.techchallenge01.pedido.utils.mapper.StatusPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class PedidoResponseDTO {

    @Schema(description = "Identificador único do pedido", example = "e389406d-5531-4acf-a354-be5cc46a8cb1")
    private String id;

    @Schema(description = "Código do pedido")
    private String codigo;

    @Schema(description = "Cliente do pedido")
    private ClienteResponseDto cliente;

    @Schema(description = "Status do pedido")
    private StatusPedido status;

    @Schema(description = "Valor total do pedido")
    private BigDecimal preco;

    @Schema(description = "Observação do pedido")
    private String observacao;

    @Schema(description = "Data de criação do pedido", example = "2023-01-01T10:00:00Z")
    private OffsetDateTime dataCriacao;

    @Schema(description = "Produtos do pedido")
    private List<ProdutoPedidoResponseDTO> produtos;
}