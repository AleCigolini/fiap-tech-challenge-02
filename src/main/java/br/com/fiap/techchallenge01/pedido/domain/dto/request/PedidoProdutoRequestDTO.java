package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoProdutoRequestDTO {

    @NotNull
    private Produto produto;

    @NotNull
    private Long quantidade;
}
