package br.com.fiap.techchallenge01.cliente.domain.dto.request;

import br.com.fiap.techchallenge01.core.utils.validators.cpf.Cpf;
import br.com.fiap.techchallenge01.cliente.domain.validator.EmailOuCpf;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@EmailOuCpf
public class ClienteRequestDto {
    private String nome;
    @Email(message = "Email inválido", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{1,}$")
    private String email;
    @Cpf
    private String cpf;
}

