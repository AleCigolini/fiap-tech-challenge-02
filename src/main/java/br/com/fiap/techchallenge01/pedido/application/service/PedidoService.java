package br.com.fiap.techchallenge01.pedido.application.service;

import br.com.fiap.techchallenge01.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoProdutoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import br.com.fiap.techchallenge01.pedido.utils.mapper.PedidoMapper;
import br.com.fiap.techchallenge01.pedido.utils.mapper.StatusPedido;
import br.com.fiap.techchallenge01.produto.application.service.ProdutoService;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge01.produto.utils.mapper.ProdutoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidoService implements PedidoUseCase {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ProdutoService produtoService;

    public PedidoService(
            PedidoRepository pedidoRepository,
            PedidoMapper pedidoMapper,
            ProdutoService produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.produtoService = produtoService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> buscarPedidos() {
        List<Pedido> pedidos = pedidoRepository.buscarPedidos();
        return pedidoMapper.toCollectionResponse(pedidos);
    }

    @Override
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {

        Pedido pedido = new Pedido();
        Produto produto;
        List<Produto> produtos = new ArrayList<>();
        var precoTotal = 0D;

        for (PedidoProdutoRequestDTO pedidoProdutoRequestDTO : pedidoRequestDTO.getProdutos()) {
            // TODO: VALDIAR NULLPOINTER
            ProdutoResponseDTO produtoResponseDTO = produtoService.buscarProdutoPorId(pedidoProdutoRequestDTO.getProduto().getId());

            produto = new Produto();
            produto.setId(produtoResponseDTO.getId());
            precoTotal += produto.getPreco();
            produtos.add(produto);
        }
//        pedido.setProdutos(produtos);
//        pedido.setCodigo("00001"); //TODO: SEMPRE GERAR UMA NOVA SEQUENCIA POR DIA
        pedido.setStatus(StatusPedido.ABERTO.toString());
        pedido.setPreco(precoTotal);

        Pedido pedidoSalvo = pedidoRepository.criarPedido(pedido);

        // TODO: CRIAR AQUI O FAKE CHECKOUT
        //  EM CASO DE SUCESSO, ALTERAR O STATUS DO PEDIDO DE "ABERTO" PARA "APROVADO"

        return pedidoMapper.toResponse(pedidoSalvo);
    }
}