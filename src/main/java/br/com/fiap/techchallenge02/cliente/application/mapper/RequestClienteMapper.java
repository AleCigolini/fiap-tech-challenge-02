package br.com.fiap.techchallenge02.cliente.application.mapper;

import br.com.fiap.techchallenge02.cliente.common.domain.dto.request.ClienteRequestDto;
import br.com.fiap.techchallenge02.cliente.domain.Cliente;

public interface RequestClienteMapper {
    Cliente requestDtoToDomain(ClienteRequestDto clienteRequestDto);
}
