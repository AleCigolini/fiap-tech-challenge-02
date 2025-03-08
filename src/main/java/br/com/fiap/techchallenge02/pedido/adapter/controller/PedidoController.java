package br.com.fiap.techchallenge02.pedido.adapter.controller;

import br.com.fiap.techchallenge02.pedido.adapter.presenter.PedidoPresenter;
import br.com.fiap.techchallenge02.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.pedido.domain.dto.response.PedidoResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;
    private final PedidoPresenter pedidoPresenter;

    public PedidoController(PedidoUseCase pedidoUseCase, PedidoPresenter pedidoPresenter) {
        this.pedidoUseCase = pedidoUseCase;
        this.pedidoPresenter = pedidoPresenter;
    }

    public List<PedidoResponseDTO> buscarPedidos(List<String> status) {
        List<StatusPedidoEnum> statusPedidoEnums = pedidoPresenter.statusPedidoTextParaStatusPedidoEnums(status);

        List<Pedido> pedidos = pedidoUseCase.buscarPedidos(statusPedidoEnums);

        return pedidoPresenter.pedidosParaPedidoResponseDTOs(pedidos);
    }
}
