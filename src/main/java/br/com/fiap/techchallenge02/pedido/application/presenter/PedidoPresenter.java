package br.com.fiap.techchallenge02.pedido.application.presenter;

import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;

import java.util.List;

public interface PedidoPresenter {

    List<PedidoResponseDto> pedidosParaPedidoResponseDTOs(List<Pedido> pedidos);

    List<StatusPedidoEnum> statusPedidoTextParaStatusPedidoEnums(List<String> status);

    StatusPedidoEnum statusPedidoTextParaStatusPedidoEnum(String status);

    PedidoResponseDto pedidoParaPedidoResponseDTO(Pedido pedido);

    Pedido pedidoRequestDtoParaPedido(PedidoResponseDto pedidoRequestDTO);
}
