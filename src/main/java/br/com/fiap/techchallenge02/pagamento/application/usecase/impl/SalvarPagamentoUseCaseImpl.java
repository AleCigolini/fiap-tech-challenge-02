package br.com.fiap.techchallenge02.pagamento.application.usecase.impl;

import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.usecase.SalvarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import br.com.fiap.techchallenge02.pagamento.domain.StatusPagamentoEnum;
import br.com.fiap.techchallenge02.pedido.domain.Pedido;
import org.springframework.transaction.annotation.Transactional;

public class SalvarPagamentoUseCaseImpl implements SalvarPagamentoUseCase {

    private final PagamentoGateway pagamentoGateway;

    public SalvarPagamentoUseCaseImpl(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    @Override
    @Transactional
    public Pagamento criarPagamentoPendenteParaOPedido(Pedido pedido, boolean criouPedidoMercadoPago) {
        Pagamento pagamento = new Pagamento();
        pagamento.setPreco(pedido.getPreco());
        pagamento.setCodigoPedido(pedido.getId());

        pagamento.setStatus(!criouPedidoMercadoPago ?
                StatusPagamentoEnum.FALHA.toString() :
                StatusPagamentoEnum.PENDENTE.toString());

        return pagamentoGateway.salvarPagamento(pagamento);
    }

    @Override
    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoGateway.salvarPagamento(pagamento);
    }
}