package br.com.fiap.techchallenge01.cliente.domain.repository;

import br.com.fiap.techchallenge01.cliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente salvarCliente(Cliente cliente);
    List<Cliente> buscarClientePorCpf(String cpf);
}
