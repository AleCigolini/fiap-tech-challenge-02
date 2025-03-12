package br.com.fiap.techchallenge02.pedido.application.controller.impl;

import br.com.fiap.techchallenge02.pedido.application.controller.PedidoController;
import br.com.fiap.techchallenge02.pedido.application.mapper.RequestPedidoMapper;
import br.com.fiap.techchallenge02.pedido.application.presenter.PedidoPresenter;
import br.com.fiap.techchallenge02.pedido.application.usecase.ConsultarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.application.usecase.SalvarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoStatusRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class PedidoControllerImpl implements PedidoController {

    private final SalvarPedidoUseCase salvarPedidoUseCase;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;

    private final RequestPedidoMapper requestPedidoMapper;
    private final PedidoPresenter pedidoPresenter;

    @Override
    public List<PedidoResponseDto> buscarPedidos(List<String> status) {
        List<StatusPedidoEnum> statusPedidoEnums =
                status == null || status.isEmpty() ?
                        null : pedidoPresenter.statusPedidoTextParaStatusPedidoEnums(status);

        return pedidoPresenter.pedidosParaPedidoResponseDTOs(
                consultarPedidoUseCase.buscarPedidos(statusPedidoEnums));
    }

    @Override
    public PedidoResponseDto criarPedido(PedidoRequestDto pedidoRequestDto) {
        return pedidoPresenter.pedidoParaPedidoResponseDTO(
                salvarPedidoUseCase.criarPedido(
                        requestPedidoMapper.pedidoRequestDtoParaPedido(pedidoRequestDto)));
    }

    @Override
    public PedidoResponseDto atualizarStatusPedido(PedidoStatusRequestDto pedidoStatusRequestDTO, String id) {
        return pedidoPresenter.pedidoParaPedidoResponseDTO(
                salvarPedidoUseCase.atualizarStatusPedido(
                        pedidoPresenter.statusPedidoTextParaStatusPedidoEnum(pedidoStatusRequestDTO.getStatus()), id));
    }
}