package br.com.fiap.techchallenge02.pagamento.application.controller.impl;

import br.com.fiap.techchallenge02.core.config.properties.MercadoPagoProperties;
import br.com.fiap.techchallenge02.pagamento.application.controller.PagamentoController;
import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.gateway.impl.PagamentoGatewayImpl;
import br.com.fiap.techchallenge02.pagamento.application.mapper.DatabasePagamentoMapper;
import br.com.fiap.techchallenge02.pagamento.application.presenter.PagamentoPresenter;
import br.com.fiap.techchallenge02.pagamento.application.usecase.ConsultarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.application.usecase.ConsultarQrCodePagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.application.usecase.impl.ConsultarPagamentoUseCaseImpl;
import br.com.fiap.techchallenge02.pagamento.application.usecase.impl.ConsultarQrCodePagamentoUseCaseImpl;
import br.com.fiap.techchallenge02.pagamento.common.domain.dto.response.PagamentoResponseDto;
import br.com.fiap.techchallenge02.pagamento.common.interfaces.PagamentoDatabase;
import br.com.fiap.techchallenge02.pedido.infrastructure.client.mercadopago.MercadoPagoPosClient;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.List;

@Component
public class PagamentoControllerImpl implements PagamentoController {

    private final ConsultarPagamentoUseCase consultarPagamentoUseCase;
    private final ConsultarQrCodePagamentoUseCase consultarQrCodePagamentoUseCase;
    private final PagamentoPresenter pagamentoPresenter;

    public PagamentoControllerImpl(
            PagamentoPresenter pagamentoPresenter,
            PagamentoDatabase pagamentoDatabase,
            DatabasePagamentoMapper databasePagamentoMapper,
            MercadoPagoPosClient mercadoPagoPosClient,
            MercadoPagoProperties mercadoPagoProperties
    ) {
        final PagamentoGateway pagamentoGateway = new PagamentoGatewayImpl(pagamentoDatabase, databasePagamentoMapper);
        this.consultarPagamentoUseCase = new ConsultarPagamentoUseCaseImpl(pagamentoGateway);
        this.consultarQrCodePagamentoUseCase = new ConsultarQrCodePagamentoUseCaseImpl(mercadoPagoPosClient, mercadoPagoProperties);
        this.pagamentoPresenter = pagamentoPresenter;
    }

    @Override
    public List<PagamentoResponseDto> buscarPagamentosPorPedidoId(String pedidoId) {
        return pagamentoPresenter.pagamentosParaPagamentoResponseDTOs(
                consultarPagamentoUseCase.buscarPagamentosPorPedidoId(pedidoId));
    }

    @Override
    public BufferedImage gerarImagemCodigoQRCaixa() {
        return consultarQrCodePagamentoUseCase.gerarImagemCodigoQRCaixa();
    }
}