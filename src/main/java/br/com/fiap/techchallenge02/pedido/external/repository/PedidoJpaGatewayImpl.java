package br.com.fiap.techchallenge02.pedido.external.repository;

import br.com.fiap.techchallenge02.pedido.adapter.gateway.PedidoGateway;
import br.com.fiap.techchallenge02.pedido.adapter.presenter.PedidoPresenter;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.pedido.external.entity.JpaPedidoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoJpaGatewayImpl implements PedidoGateway {

    private final PedidoJpaRepository pedidoJpaRepository;
    private final PedidoPresenter pedidoPresenter;

    public PedidoJpaGatewayImpl(PedidoJpaRepository pedidoJpaRepository, PedidoPresenter pedidoPresenter) {
        this.pedidoJpaRepository = pedidoJpaRepository;
        this.pedidoPresenter = pedidoPresenter;
    }

    @Override
    public List<Pedido> buscarPedidos(List<StatusPedidoEnum> statusPedidoEnums) {
        List<String> status = statusPedidoEnums.stream().map(StatusPedidoEnum::toString).toList();

        List<JpaPedidoEntity> jpaPedidoEntities = pedidoJpaRepository.findAllByStatusIn(status);

        return pedidoPresenter.jpaPedidoEntitiesParaPedidos(jpaPedidoEntities);
    }
}
