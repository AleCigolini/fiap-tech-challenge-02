package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {

    @NotEmpty
    private List<ProdutoPedidoRequestDTO> produtos;

    @NotNull
    private String observacao;
}