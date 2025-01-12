package br.com.fiap.techchallenge01.cliente.domain.validator;

import br.com.fiap.techchallenge01.cliente.utils.validadores.cpf.ValidadorCpf;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<Cpf, String> {
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        return cpf == null || ValidadorCpf.isValidCPF(cpf);
    }
}
