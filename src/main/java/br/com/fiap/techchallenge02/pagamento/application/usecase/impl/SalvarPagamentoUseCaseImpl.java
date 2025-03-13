package br.com.fiap.techchallenge02.pagamento.application.usecase.impl;

import br.com.fiap.techchallenge02.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.techchallenge02.pagamento.application.usecase.SalvarPagamentoUseCase;
import br.com.fiap.techchallenge02.pagamento.domain.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalvarPagamentoUseCaseImpl implements SalvarPagamentoUseCase {

    private final PagamentoGateway pagamentoOutputPort;

    @Autowired
    public SalvarPagamentoUseCaseImpl(PagamentoGateway pagamentoOutputPort) {
        this.pagamentoOutputPort = pagamentoOutputPort;
    }

    @Override
    @Transactional
    public Pagamento salvarPagamento(Pagamento pagamento) {
        // TODO: FAZER TENTATIVA DE PAGAMENTO E SALVAR COM STATUS PENDENTE
        //  DEPOIS VIA WEBHOOK O STATUS DO PAGAMENTO E DO PEDIDO DEVEM SER ATUALIZADOS
        //  STATUS_PAGAMENTO: O QUE RETORNAR DO MERCADO PAGO;
        //  STATUS_PEDIDO: SE RETORNAR SUCESSO DO MERCADO PAGO ENTÃO ALTERAR O STATUS DO PEDIDO PARA StatusPedidoEnum.APROVADO("Aprovado")
        Pagamento pagamentoSalvo = pagamentoOutputPort.salvarPagamento(pagamento);
        return pagamentoSalvo;
    }
}