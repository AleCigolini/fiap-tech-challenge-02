package br.com.fiap.techchallenge01.pedido.domain.dto.response;

import br.com.fiap.techchallenge01.pedido.utils.mapper.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Schema(description = "Status do pedido")
    private StatusPedido status;

    @Schema(description = "Valor total do pedido")
    private BigDecimal preco;

    @Schema(description = "Observação do pedido")
    private String observacao;

    @Schema(description = "Data de criação do pedido", example = "10/01/2025 11:11")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm", timezone="GMT-3")
    private OffsetDateTime dataCriacao;

    @Schema(description = "Produtos do pedido")
    private List<ProdutoPedidoResponseDTO> produtos;
}