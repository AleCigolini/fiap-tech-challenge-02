package br.com.fiap.techchallenge02.cliente.application.mapper.modelmapper;

import br.com.fiap.techchallenge02.cliente.application.mapper.RequestClienteMapper;
import br.com.fiap.techchallenge02.cliente.common.domain.dto.request.ClienteRequestDto;
import br.com.fiap.techchallenge02.cliente.domain.Cliente;
import br.com.fiap.techchallenge02.core.config.exception.exceptions.ValidacaoEntidadeException;
import lombok.AllArgsConstructor;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RequestRequestClienteModelMapper implements RequestClienteMapper {
    private ModelMapper modelMapper;

    public Cliente requestDtoToDomain(ClienteRequestDto clienteRequestDto) {
        try {
            return modelMapper.map(clienteRequestDto, Cliente.class);
        } catch (MappingException e) {
            if (e.getCause() instanceof ValidacaoEntidadeException) {
                throw (ValidacaoEntidadeException) e.getCause();
            }
            throw e;
        }
    }
}
