package br.com.fiap.techchallenge02.pedido.adapter.presenter;

import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge02.pedido.external.entity.JpaPedidoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoPresenterImpl implements PedidoPresenter {

    private final ModelMapper modelMapper;

    public PedidoPresenterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Pedido> jpaPedidoEntitiesParaPedidos(List<JpaPedidoEntity> jpaPedidoEntities) {
        return jpaPedidoEntities.stream().map(jpaPedidoEntity -> modelMapper.map(jpaPedidoEntity, Pedido.class)).toList();
    }

    @Override
    public List<PedidoResponseDTO> pedidosParaPedidoResponseDTOs(List<Pedido> pedidos) {
        return pedidos.stream().map(pedido -> modelMapper.map(pedido, PedidoResponseDTO.class)).toList();
    }

    @Override
    public List<StatusPedidoEnum> statusPedidoTextParaStatusPedidoEnums(List<String> status) {
        return status.stream().map(StatusPedidoEnum::fromStringStatus).toList();
    }
}
