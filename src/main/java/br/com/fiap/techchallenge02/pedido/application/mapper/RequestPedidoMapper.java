package br.com.fiap.techchallenge02.pedido.application.mapper;

import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;

public interface RequestPedidoMapper {

    Pedido requestDtoToDomain(PedidoRequestDto clienteRequestDto);
}