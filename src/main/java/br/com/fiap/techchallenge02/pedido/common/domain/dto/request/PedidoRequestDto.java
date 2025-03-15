package br.com.fiap.techchallenge02.pedido.common.domain.dto.request;

import br.com.fiap.techchallenge02.cliente.common.domain.dto.request.ClienteRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDto {

    @NotBlank
    private String observacao;

    @NotNull
    private ClienteRequestDto cliente;

    @NotEmpty
    private List<ProdutoPedidoRequestDto> produtos;
}

