package br.com.fiap.techchallenge01.cliente.application.service;

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
        validarClientesEncontradosPorCpf(usuariosEncontradosPorCpf);
        return usuariosEncontradosPorCpf.getFirst();
    }

    private void validarClientesEncontradosPorCpf(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        if (clientes.size() > 1) {
            throw new RuntimeException("Mais de um usuário encontrado");
        }
    }
}
