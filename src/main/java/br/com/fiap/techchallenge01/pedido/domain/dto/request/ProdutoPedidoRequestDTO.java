package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProdutoPedidoRequestDTO {

    @NotEmpty
    private String idProduto;

    @NotEmpty
    private String observacao;

    @NotEmpty
    private Long quantidade;
}
