package br.com.fiap.techchallenge02.produto.application.usecase;

import br.com.fiap.techchallenge02.produto.adapter.gateway.ProdutoGateway;
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
