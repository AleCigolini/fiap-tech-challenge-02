package br.com.fiap.techchallenge01.cliente.domain;

import br.com.fiap.techchallenge01.cliente.domain.validator.EmailOuCpf;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@EmailOuCpf
public class ClienteRequestDto {
    private String nome;
    @Email(message = "Email inválido")
    private String email;

    private String cpf;

}

