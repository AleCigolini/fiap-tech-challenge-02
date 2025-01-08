package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PedidoStatusRequestDTO {

    @NotEmpty
    private String status; // TODO: CONVERTER EM ENUM? "ABERTO", APROVADO, "EM_ANDAMENTO", "ENTREGUE", "FINALIZADO", "CANCELADO"

}