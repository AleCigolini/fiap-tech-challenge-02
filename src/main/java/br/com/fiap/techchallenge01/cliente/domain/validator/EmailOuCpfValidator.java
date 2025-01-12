package br.com.fiap.techchallenge01.cliente.domain.validator;

import br.com.fiap.techchallenge01.cliente.domain.ClienteRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailOuCpfValidator implements ConstraintValidator<EmailOuCpf, ClienteRequestDto> {
    @Override
    public boolean isValid(ClienteRequestDto clienteRequestDto, ConstraintValidatorContext context) {
        return clienteRequestDto != null &&
                ((clienteRequestDto.getEmail() != null && !clienteRequestDto.getEmail().isBlank()) ||
                        (clienteRequestDto.getCpf() != null && !clienteRequestDto.getCpf().isBlank()));
    }
}
