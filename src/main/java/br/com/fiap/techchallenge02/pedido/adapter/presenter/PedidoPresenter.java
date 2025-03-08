package br.com.fiap.techchallenge02.pedido.adapter.presenter;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge02.pedido.external.entity.JpaPedidoEntity;

import java.util.List;

public interface PedidoPresenter {

    List<Pedido> jpaPedidoEntitiesParaPedidos(List<JpaPedidoEntity> jpaPedidoEntities);

    List<PedidoResponseDTO> pedidosParaPedidoResponseDTOs(List<Pedido> pedidos);

    List<StatusPedidoEnum> statusPedidoTextParaStatusPedidoEnums(List<String> status);
}
