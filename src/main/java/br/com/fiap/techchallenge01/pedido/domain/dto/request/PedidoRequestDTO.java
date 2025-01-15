package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import br.com.fiap.techchallenge01.cliente.domain.dto.request.ClienteRequestDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {

    @NotEmpty
    private String observacao;

    @NotNull
    private ClienteRequestDto cliente;

    @NotEmpty
    private List<ProdutoPedidoRequestDTO> produtos;
}