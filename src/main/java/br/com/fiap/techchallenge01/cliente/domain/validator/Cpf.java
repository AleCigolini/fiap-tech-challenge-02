package br.com.fiap.techchallenge01.cliente.domain.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CpfValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {
    String message() default "É necessário um cpf válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
