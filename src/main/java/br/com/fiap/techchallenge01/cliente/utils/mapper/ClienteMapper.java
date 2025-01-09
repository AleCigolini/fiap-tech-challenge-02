package br.com.fiap.techchallenge01.cliente.utils.mapper;

import br.com.fiap.techchallenge01.cliente.domain.Cliente;
import br.com.fiap.techchallenge01.cliente.domain.ClienteRequestDto;
import br.com.fiap.techchallenge01.cliente.domain.ClienteResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteMapper {
    private ModelMapper modelMapper;

    public ClienteResponseDto toResponse(Cliente usuario) {
        return modelMapper.map(usuario, ClienteResponseDto.class);
    }

    public Cliente requestDtoToDomain(ClienteRequestDto clienteRequestDto) {
        return modelMapper.map(clienteRequestDto, Cliente.class);
    }

}
