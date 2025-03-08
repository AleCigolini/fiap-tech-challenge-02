package br.com.fiap.techchallenge02.pedido.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {

    @NotBlank
    private String observacao;

//    @NotNull
//    private ClienteRequestDto cliente;

    @NotEmpty
    private List<ProdutoPedidoRequestDTO> produtos;
}