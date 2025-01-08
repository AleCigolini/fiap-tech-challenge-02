package br.com.fiap.techchallenge01.pedido.application.service;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.application.exception.PedidoNaoEncontradoException;
import br.com.fiap.techchallenge01.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoProdutoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoStatusRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import br.com.fiap.techchallenge01.pedido.utils.mapper.PedidoMapper;
import br.com.fiap.techchallenge01.produto.application.service.ProdutoService;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
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

    public PedidoService(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper, ProdutoService produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.produtoService = produtoService;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Pedido> buscarPedidos() {
        return pedidoRepository.buscarPedidos();
    }

    @Override
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {

        List<Produto> produtos = new ArrayList<>();
        Produto produto;
        for (PedidoProdutoRequestDTO pedidoProdutoRequestDTO : pedidoRequestDTO.getProdutos()) {
            ProdutoResponseDTO produtoResponseDTO = produtoService.buscarProdutoPorId(pedidoProdutoRequestDTO.getId());
            produto = new Produto();
            produto.setId(produtoResponseDTO.getId());
            produto.setPreco(produtoResponseDTO.getPreco());
            produtos.add(produto);
        }

        JpaPedidoEntity jpaPedidoEntity = pedidoMapper.toJpaPedidoEntity(produtos);
        Pedido pedido = pedidoRepository.criarPedido(jpaPedidoEntity);

        // TODO: CRIAR AQUI O FAKE CHECKOUT
        //  EM CASO DE SUCESSO, ALTERAR O STATUS DO PEDIDO DE "ABERTO" PARA "APROVADO"

        return pedidoMapper.toResponse(pedido);
    }
}