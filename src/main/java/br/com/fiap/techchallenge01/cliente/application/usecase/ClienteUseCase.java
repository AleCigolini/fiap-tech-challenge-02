package br.com.fiap.techchallenge01.cliente.application.usecase;

import br.com.fiap.techchallenge01.cliente.domain.Cliente;

public interface ClienteUseCase {
    Cliente salvarCliente(Cliente cliente);
    Cliente buscarClientePorCpf(String cpf);
}
