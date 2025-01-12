package br.com.fiap.techchallenge01.cliente.application.service;

import br.com.fiap.techchallenge01.cliente.application.exception.ClienteNaoEncontradoException;
import br.com.fiap.techchallenge01.cliente.application.exception.ClienteValidacaoException;
import br.com.fiap.techchallenge01.cliente.application.usecase.ClienteUseCase;
import br.com.fiap.techchallenge01.cliente.domain.Cliente;
import br.com.fiap.techchallenge01.cliente.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService implements ClienteUseCase {
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.salvarCliente(cliente);
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        List<Cliente> usuariosEncontradosPorCpf = clienteRepository.buscarClientePorCpf(cpf);
        validarClientesEncontradosPorCpf(usuariosEncontradosPorCpf, cpf);
        return usuariosEncontradosPorCpf.getFirst();
    }

    private void validarClientesEncontradosPorCpf(List<Cliente> clientes, String cpf) {
        if (clientes.isEmpty()) {
            throw new ClienteNaoEncontradoException(String.format("Não foi encontrado nenhum cliente para o cpf: %s", cpf));
        }
        if (clientes.size() > 1) {
            throw new ClienteValidacaoException(String.format("Encontrado mais de um cliente para o cpf: %s", cpf));
        }
    }
}
