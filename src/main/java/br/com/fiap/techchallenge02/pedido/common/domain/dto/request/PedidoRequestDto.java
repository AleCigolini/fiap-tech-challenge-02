package br.com.fiap.techchallenge02.pedido.common.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
//@EmailOuCpf
public class PedidoRequestDto {
//    @Size(max = 255, message = "O nome deve ter {max} caracteres")
//    private String nome;
//    @Size(max = 255, message = "O e-mail deve ter {max} caracteres")
//    private String email;
//    @Cpf
//    private String cpf;

    @NotBlank
    private String observacao;

//    @NotNull
//    private ClienteRequestDto cliente;

    @NotEmpty
    private List<ProdutoPedidoRequestDto> produtos;
}

