package br.com.fiap.techchallenge02.pedido.common.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDto {

    @NotBlank
    private String observacao;

//    @NotNull
//    private ClienteRequestDto cliente;

    @NotEmpty
    private List<ProdutoPedidoRequestDto> produtos;
}

