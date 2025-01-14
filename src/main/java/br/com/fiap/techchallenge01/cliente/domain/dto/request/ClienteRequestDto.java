package br.com.fiap.techchallenge01.cliente.domain.dto.request;

import br.com.fiap.techchallenge01.cliente.domain.validator.EmailOuCpf;
import br.com.fiap.techchallenge01.core.utils.validators.cpf.Cpf;
import br.com.fiap.techchallenge01.core.utils.validators.email.EmailValido;
import lombok.Data;

@Data
@EmailOuCpf
public class ClienteRequestDto {
    private String nome;
    @EmailValido
    private String email;
    @Cpf
    private String cpf;
}

