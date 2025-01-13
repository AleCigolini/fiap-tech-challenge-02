package br.com.fiap.techchallenge01.pedido.application.service;

import br.com.fiap.techchallenge01.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import br.com.fiap.techchallenge01.pedido.utils.mapper.PedidoMapper;
import br.com.fiap.techchallenge01.produto.application.service.ProdutoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PedidoService implements PedidoUseCase {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(
            PedidoRepository pedidoRepository,
            PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> buscarPedidos() {
        List<Pedido> pedidos = pedidoRepository.buscarPedidos();
        return pedidoMapper.toCollectionResponse(pedidos);
    }

    @Override
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoMapper.toPedido(pedidoRequestDTO);
        Pedido pedidoSalvo = pedidoRepository.criarPedido(pedido);

        // TODO: CRIAR AQUI O FAKE CHECKOUT
        //  EM CASO DE SUCESSO, ALTERAR O STATUS DO PEDIDO DE "ABERTO" PARA "APROVADO"

        return pedidoMapper.toResponse(pedidoSalvo);
    }
}