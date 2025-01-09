package br.com.fiap.techchallenge01.pedido.application.service;

import br.com.fiap.techchallenge01.pedido.application.usecase.PedidoUseCase;
import br.com.fiap.techchallenge01.pedido.domain.Pedido;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoListaProdutoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.request.PedidoRequestDTO;
import br.com.fiap.techchallenge01.pedido.domain.dto.response.PedidoResponseDTO;
import br.com.fiap.techchallenge01.pedido.domain.repository.PedidoRepository;
import br.com.fiap.techchallenge01.pedido.utils.mapper.PedidoMapper;
import br.com.fiap.techchallenge01.pedido.utils.mapper.StatusPedido;
import br.com.fiap.techchallenge01.produto.application.service.ProdutoService;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<Produto> produtos = new ArrayList<>();
        var precoTotal = 0D;
        Produto produtoEncontrado;

        for (PedidoListaProdutoRequestDTO pedidoProdutoRequestDTO : pedidoRequestDTO.getProdutos()) {
            // TODO: VALIDAR NULLPOINTER
            produtoEncontrado = produtoService.obterProdutoPorId(pedidoProdutoRequestDTO.getProduto().getId());
            precoTotal += produtoEncontrado.getPreco() * pedidoProdutoRequestDTO.getQuantidade();
            produtos.add(produtoEncontrado);
        }
//        pedido.setProdutos(produtos);
        pedido.setCodigo(gerarCodigo());
        pedido.setStatus(StatusPedido.ABERTO.toString());
        pedido.setPreco(precoTotal);

        Pedido pedidoSalvo = pedidoRepository.criarPedido(pedido);

        // TODO: CRIAR AQUI O FAKE CHECKOUT
        //  EM CASO DE SUCESSO, ALTERAR O STATUS DO PEDIDO DE "ABERTO" PARA "APROVADO"

        return pedidoMapper.toResponse(pedidoSalvo);
    }

    //TODO: SEMPRE ZERAR SEQUENCIA A CADA DIA
    // CRIAR UMA TABELA BUSCANDO NO BANCO A PRÓXIMA SEQUENCIA DE CÓDIGO + TIMESTAMP
    // MOVER PARA O UTILS
    private String gerarCodigo() {

        var CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        var TAMANHO_CODIGO = 5;

        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < TAMANHO_CODIGO; i++) {
            int indice = random.nextInt(CARACTERES.length());
            codigo.append(CARACTERES.charAt(indice));
        }

        return codigo.toString();
    }
}