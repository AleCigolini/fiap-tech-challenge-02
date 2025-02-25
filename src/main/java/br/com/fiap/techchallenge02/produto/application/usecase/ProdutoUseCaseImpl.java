package br.com.fiap.techchallenge02.produto.application.usecase;

import br.com.fiap.techchallenge02.produto.adapter.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoGateway.buscarProdutos();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        return produtoGateway.buscarProdutosPorCategoria(idCategoriaProduto);
    }

    @Override
    public Produto buscarProdutoPorId(String id) {
        Produto produto = produtoGateway.buscarProdutoPorId(id);

        if (produto == null) {
            throw new ProdutoNaoEncontradoException(id);
        }

        return produto;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoGateway.criarProduto(produto);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoGateway.atualizarProduto(produto);
    }

    //    @Override
//    public ProdutoResponseDTO buscarProdutoPorId(String id) {
//        return null;
//    }
//
//    @Override
//    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {
//        return null;
//    }
//
//    @Override
//    public ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String idProduto) {
//        return null;
//    }
//
//    @Override
//    public void excluirProduto(String idProduto) {
//
//    }
//
//    @Override
//    public List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto) {
//        return List.of();
//    }
}
