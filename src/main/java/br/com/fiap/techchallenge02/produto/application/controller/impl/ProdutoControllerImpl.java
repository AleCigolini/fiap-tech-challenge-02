package br.com.fiap.techchallenge02.produto.application.controller.impl;

import br.com.fiap.techchallenge02.produto.application.controller.CategoriaProdutoController;
import br.com.fiap.techchallenge02.produto.application.controller.ProdutoController;
import br.com.fiap.techchallenge02.produto.application.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.gateway.impl.ProdutoGatewayImpl;
import br.com.fiap.techchallenge02.produto.application.mapper.ProdutoMapper;
import br.com.fiap.techchallenge02.produto.application.mapper.impl.ProdutoMapperImpl;
import br.com.fiap.techchallenge02.produto.application.presenter.ProdutoPresenter;
import br.com.fiap.techchallenge02.produto.application.presenter.impl.ProdutoModelMapperPresenterImpl;
import br.com.fiap.techchallenge02.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge02.produto.application.usecase.impl.ProdutoUseCaseImpl;
import br.com.fiap.techchallenge02.produto.common.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.common.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.infrastructure.database.adpater.ProdutoDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoControllerImpl implements ProdutoController {

    private final ProdutoUseCase produtoUseCase;
    private final ProdutoPresenter produtoPresenter;
    private final ProdutoMapper produtoMapper;
    private final CategoriaProdutoController categoriaProdutoController;

    public ProdutoControllerImpl(ModelMapper modelMapper, ProdutoDatabase produtoDatabase, CategoriaProdutoController categoriaProdutoController) {
        this.produtoPresenter = new ProdutoModelMapperPresenterImpl(modelMapper);
        this.produtoMapper = new ProdutoMapperImpl(modelMapper);
        final ProdutoGateway produtoGateway = new ProdutoGatewayImpl(produtoDatabase, produtoMapper);
        this.produtoUseCase = new ProdutoUseCaseImpl(produtoGateway);
        this.categoriaProdutoController = categoriaProdutoController;
    }

    public List<ProdutoResponseDTO> buscarProdutos() {
        List<Produto> produtos = produtoUseCase.buscarProdutos();

        return produtoPresenter.produtosParaProdutosResponseDTO(produtos);
    }

    public List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto) {
        List<Produto> produtos = produtoUseCase.buscarProdutosPorCategoria(idCategoriaProduto);

        List<ProdutoResponseDTO> produtosResponseDTOs = produtoPresenter.produtosParaProdutosResponseDTO(produtos);

        produtosResponseDTOs.forEach(produtoResponseDTO -> {
            CategoriaProduto categoriaProduto = categoriaProdutoController.buscarCategoriaProdutoPorId(produtoResponseDTO.getCategoriaProduto().getId());
            produtoResponseDTO.setCategoriaProduto(categoriaProduto);
        });

        return produtosResponseDTOs;
    }

    public ProdutoResponseDTO buscarProdutoPorId(String id) {
        Produto produto = produtoUseCase.buscarProdutoPorId(id);

        return produtoPresenter.produtoParaProdutoResponseDTO(produto);
    }

    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoMapper.produtoRequestDtoParaProduto(produtoRequestDTO);

        Produto produtoCriado = produtoUseCase.criarProduto(produto);
        CategoriaProduto categoriaProduto = categoriaProdutoController.buscarCategoriaProdutoPorId(produtoRequestDTO.getIdCategoria());

        ProdutoResponseDTO produtoResponseDTO = produtoPresenter.produtoParaProdutoResponseDTO(produtoCriado);
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }

    public ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String id) {
        produtoUseCase.buscarProdutoPorId(id);

        Produto produto = produtoMapper.produtoRequestDtoParaProduto(produtoRequestDTO);
        produto.setId(id);

        Produto produtoAtualizado = produtoUseCase.atualizarProduto(produto);
        CategoriaProduto categoriaProduto = categoriaProdutoController.buscarCategoriaProdutoPorId(produtoRequestDTO.getIdCategoria());

        ProdutoResponseDTO produtoResponseDTO = produtoPresenter.produtoParaProdutoResponseDTO(produtoAtualizado);
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }

    public void excluirProduto(String idProduto) {
        produtoUseCase.excluirProduto(idProduto);
    }
}
