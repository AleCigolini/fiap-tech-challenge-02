package br.com.fiap.techchallenge02.pedido.application.controller.impl;

import br.com.fiap.techchallenge02.cliente.application.gateway.ClienteGateway;
import br.com.fiap.techchallenge02.cliente.application.gateway.impl.ClienteGatewayImpl;
import br.com.fiap.techchallenge02.cliente.application.mapper.DatabaseClienteMapper;
import br.com.fiap.techchallenge02.cliente.application.usecase.ConsultarClienteUseCase;
import br.com.fiap.techchallenge02.cliente.application.usecase.impl.ConsultarClienteUseCaseImpl;
import br.com.fiap.techchallenge02.cliente.common.interfaces.ClienteDatabase;
import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.gateway.impl.PagamentoGatewayImpl;
import br.com.fiap.techchallenge02.pagamento.application.mapper.DatabasePagamentoMapper;
import br.com.fiap.techchallenge02.pagamento.application.usecase.SalvarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.application.usecase.impl.SalvarPagamentoUseCaseImpl;
import br.com.fiap.techchallenge02.pagamento.common.interfaces.PagamentoDatabase;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoCodigoQRClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.MercadoPagoPosClient;
import br.com.fiap.techchallenge02.pagamento.infrastructure.client.mercadopago.mapper.MercadoPagoOrderRequestMapper;
import br.com.fiap.techchallenge02.pedido.application.controller.PedidoController;
import br.com.fiap.techchallenge02.pedido.application.gateway.PedidoGateway;
import br.com.fiap.techchallenge02.pedido.application.gateway.impl.PedidoGatewayImpl;
import br.com.fiap.techchallenge02.pedido.application.mapper.DatabasePedidoMapper;
import br.com.fiap.techchallenge02.pedido.application.mapper.RequestPedidoMapper;
import br.com.fiap.techchallenge02.pedido.application.presenter.PedidoPresenter;
import br.com.fiap.techchallenge02.pedido.application.usecase.ConsultarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.application.usecase.SalvarPedidoUseCase;
import br.com.fiap.techchallenge02.pedido.application.usecase.impl.ConsultarPedidoUseCaseImpl;
import br.com.fiap.techchallenge02.pedido.application.usecase.impl.SalvarPedidoUseCaseImpl;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.request.PedidoStatusRequestDto;
import br.com.fiap.techchallenge02.pedido.common.domain.dto.response.PedidoResponseDto;
import br.com.fiap.techchallenge02.pedido.common.interfaces.PedidoDatabase;
import br.com.fiap.techchallenge02.pedido.domain.StatusPedidoEnum;
import br.com.fiap.techchallenge02.produto.application.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.gateway.impl.ProdutoGatewayImpl;
import br.com.fiap.techchallenge02.produto.application.mapper.ProdutoMapper;
import br.com.fiap.techchallenge02.produto.application.usecase.BuscarProdutoUseCase;
import br.com.fiap.techchallenge02.produto.application.usecase.impl.BuscarProdutoUseCaseImpl;
import br.com.fiap.techchallenge02.produto.infrastructure.database.adpater.ProdutoDatabase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoControllerImpl implements PedidoController {

    private final SalvarPedidoUseCase salvarPedidoUseCase;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;
    private final RequestPedidoMapper requestPedidoMapper;
    private final PedidoPresenter pedidoPresenter;

    public PedidoControllerImpl(PedidoDatabase pedidoDatabase,
                                ProdutoDatabase produtoDatabase,
                                ClienteDatabase clienteDatabase,
                                PagamentoDatabase pagamentoDatabase,
                                ProdutoMapper produtoMapper,
                                RequestPedidoMapper requestPedidoMapper,
                                DatabaseClienteMapper databaseClienteMapper,
                                DatabasePedidoMapper databasePedidoMapper,
                                DatabasePagamentoMapper databasePagamentoMapper,
                                MercadoPagoOrderRequestMapper mercadoPagoOrderRequestMapper,
                                PedidoPresenter pedidoPresenter,
                                MercadoPagoCodigoQRClient mercadoPagoCodigoQRClient,
                                MercadoPagoPosClient mercadoPagoPosClient
    ) {
        final PagamentoGateway pagamentoGateway = new PagamentoGatewayImpl(pagamentoDatabase, databasePagamentoMapper);
        SalvarPagamentoUseCase salvarPagamentoUseCase = new SalvarPagamentoUseCaseImpl(pagamentoGateway, mercadoPagoCodigoQRClient, mercadoPagoPosClient, mercadoPagoOrderRequestMapper);

        final ClienteGateway clienteGateway = new ClienteGatewayImpl(clienteDatabase, databaseClienteMapper);
        ConsultarClienteUseCase consultarClienteUseCase = new ConsultarClienteUseCaseImpl(clienteGateway);

        final ProdutoGateway produtoGateway = new ProdutoGatewayImpl(produtoDatabase, produtoMapper);
        BuscarProdutoUseCase buscarProdutoUseCase = new BuscarProdutoUseCaseImpl(produtoGateway);


        final PedidoGateway pedidoGateway = new PedidoGatewayImpl(pedidoDatabase, databasePedidoMapper);
        this.salvarPedidoUseCase = new SalvarPedidoUseCaseImpl(pedidoGateway, buscarProdutoUseCase, consultarClienteUseCase, salvarPagamentoUseCase);
        this.consultarPedidoUseCase = new ConsultarPedidoUseCaseImpl(pedidoGateway);

        this.requestPedidoMapper = requestPedidoMapper;
        this.pedidoPresenter = pedidoPresenter;
    }

    @Override
    public List<PedidoResponseDto> buscarPedidos(List<String> status) {
        List<StatusPedidoEnum> statusPedidoEnums =
                status == null || status.isEmpty() ?
                        null : pedidoPresenter.statusPedidoParaStatusPedidoEnums(status);

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
                        pedidoPresenter.statusPedidoParaStatusPedidoEnum(pedidoStatusRequestDTO.getStatus()), id));
    }
}