package br.com.fiap.techchallenge01.pedido.application.service;

import br.com.fiap.techchallenge01.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge01.pedido.domain.Pagamento;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.pedido.domain.repository.PagamentoRepository;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import br.com.fiap.techchallenge01.pedido.utils.mapper.PedidoMapper;
import br.com.fiap.techchallenge01.pedido.utils.mapper.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PedidoService implements PedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public List<PedidoResponseDTO> buscarPedidos() {
        List<Pedido> pedidos = pedidoRepository.buscarPedidos();
        return pedidoMapper.toCollectionResponse(pedidos);
    }

    @Override
    @Transactional
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoMapper.toPedido(pedidoRequestDTO);
        Pedido pedidoSalvo = pedidoRepository.criarPedido(pedido);

        enviarPagamento(pedidoSalvo);

        return pedidoMapper.toResponse(pedidoSalvo);
    }

    private void enviarPagamento(Pedido pedido) {
        Pagamento pagamento = new Pagamento();
        pagamento.setPreco(pedido.getPreco());
        pagamento.setCodigoPedido(pedido.getId());
        Pagamento pagamentoEfetuado = pagamentoRepository.enviarPagamento(pagamento);

        pedido.setStatus(StatusPedido.APROVADO.toString());
        pedido.setCodigoPagamento(pagamentoEfetuado.getId());
        pedido.setDataAlteracao(OffsetDateTime.now());
        pedidoRepository.atualizarStatusPedido(pedido);
    }
}