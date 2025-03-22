package br.com.fiap.techchallenge02.cliente.application.gateway;

import br.com.fiap.techchallenge02.cliente.domain.Cliente;
import br.com.fiap.techchallenge02.core.utils.domain.Cpf;
import br.com.fiap.techchallenge02.core.utils.domain.Email;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteGateway {
    Cliente salvarCliente(Cliente cliente);
    List<Cliente> buscarClientePorCpf(Cpf cpf);
    Optional<Cliente> buscarClientePorId(UUID id);
    List<Cliente> buscarClientePorEmail(Email email);
}
