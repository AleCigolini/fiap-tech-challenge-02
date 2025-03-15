package br.com.fiap.techchallenge02.pedido.common.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidoStatusRequestDto {

    @NotBlank
    private String status;
}