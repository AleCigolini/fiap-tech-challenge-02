package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoProdutoRequestDTO {

    @NotNull
    private Long id;
}
