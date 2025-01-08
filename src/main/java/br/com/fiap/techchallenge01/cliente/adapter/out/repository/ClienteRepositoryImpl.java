package br.com.fiap.techchallenge01.cliente.adapter.out.repository;

import br.com.fiap.techchallenge01.cliente.adapter.out.entity.JpaClienteEntity;
import br.com.fiap.techchallenge01.cliente.domain.Cliente;
import br.com.fiap.techchallenge01.cliente.domain.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    @Autowired
    private JpaClienteRepository jpaClienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Cliente salvarCliente(Cliente usuario) {
        JpaClienteEntity jpaClienteEntity = modelMapper.map(usuario, JpaClienteEntity.class);
        return modelMapper.map(jpaClienteRepository.save(jpaClienteEntity), Cliente.class);
    }

    @Override
    public List<Cliente> buscarClientePorCpf(String cpf) {
        return jpaClienteRepository.findByCpf(cpf)
                .stream()
                .map(jpaClienteEntity -> modelMapper.map(jpaClienteEntity, Cliente.class))
                .collect(Collectors.toList());
    }
}
