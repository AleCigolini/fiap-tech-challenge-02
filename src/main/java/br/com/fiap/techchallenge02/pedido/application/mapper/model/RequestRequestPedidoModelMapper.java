package br.com.fiap.techchallenge02.pedido.application.mapper.model;

import br.com.fiap.techchallenge02.core.config.exception.exceptions.ValidacaoEntidadeException;
import br.com.fiap.techchallenge02.pedido.application.mapper.RequestPedidoMapper;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import lombok.AllArgsConstructor;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RequestRequestPedidoModelMapper implements RequestPedidoMapper {
    private ModelMapper modelMapper;

    public Pedido requestDtoToDomain(PedidoRequestDto pedidoRequestDto) {
        try {
            return modelMapper.map(pedidoRequestDto, Pedido.class);
        } catch (MappingException e) {
            if (e.getCause() instanceof ValidacaoEntidadeException) {
                throw (ValidacaoEntidadeException) e.getCause();
            }
            throw e;
        }
    }
}
