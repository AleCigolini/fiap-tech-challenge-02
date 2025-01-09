package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoListaProdutoRequestDTO {

    @NotNull
    private PedidoProdutoRequestDTO produto;

    @NotNull
    private Long quantidade;
}
