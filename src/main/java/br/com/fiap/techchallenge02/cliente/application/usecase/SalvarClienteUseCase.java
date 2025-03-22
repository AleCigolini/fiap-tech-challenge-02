package br.com.fiap.techchallenge02.cliente.application.usecase;

import br.com.fiap.techchallenge02.cliente.domain.Cliente;

public interface SalvarClienteUseCase {
    Cliente salvarCliente(Cliente clienteRequestDto);
}
