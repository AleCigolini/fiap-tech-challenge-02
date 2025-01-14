package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoPedidoRequestDTO {

    @NotNull
    private String id;

    @NotNull
    private String observacao;

    @NotNull
    private Long quantidade;
}
