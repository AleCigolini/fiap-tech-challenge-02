package br.com.fiap.techchallenge02.produto.application.controller.impl;

import br.com.fiap.techchallenge02.produto.application.controller.CategoriaProdutoController;
import br.com.fiap.techchallenge02.produto.application.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.gateway.impl.CategoriaProdutoGatewayImpl;
import br.com.fiap.techchallenge02.produto.application.mapper.CategoriaProdutoMapper;
import br.com.fiap.techchallenge02.produto.application.mapper.impl.CategoriaProdutoMapperImpl;
import br.com.fiap.techchallenge02.produto.application.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto.application.presenter.impl.CategoriaProdutoModelMapperPresenterImpl;
import br.com.fiap.techchallenge02.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.application.usecase.impl.CategoriaProdutoUseCaseImpl;
import br.com.fiap.techchallenge02.produto.common.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.common.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.infrastructure.database.adpater.CategoriaProdutoDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaProdutoControllerImpl implements CategoriaProdutoController {

    private final CategoriaProdutoUseCase categoriaProdutoUseCase;
    private final CategoriaProdutoPresenter categoriaProdutoPresenter;
    private final CategoriaProdutoMapper categoriaProdutoMapper;

    public CategoriaProdutoControllerImpl(ModelMapper modelMapper, CategoriaProdutoDatabase categoriaProdutoDatabase) {
        this.categoriaProdutoPresenter = new CategoriaProdutoModelMapperPresenterImpl(modelMapper);
        this.categoriaProdutoMapper = new CategoriaProdutoMapperImpl(modelMapper);
        final CategoriaProdutoGateway categoriaProdutoGateway = new CategoriaProdutoGatewayImpl(categoriaProdutoDatabase, categoriaProdutoMapper);
        this.categoriaProdutoUseCase = new CategoriaProdutoUseCaseImpl(categoriaProdutoGateway);
    }

    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
    }

    public List<CategoriaProdutoResponseDTO> buscarCategoriasProduto() {
        List<CategoriaProduto> categoriaProdutos = categoriaProdutoUseCase.buscarCategoriasProduto();

        return categoriaProdutoPresenter.categoriasProdutoParaCategoriasProdutoResponseDTO(categoriaProdutos);
    }

    @Override
    public CategoriaProdutoResponseDTO criarCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoMapper.categoriaProdutoRequestDTOParaCategoriaProduto(categoriaProdutoRequestDTO);
        CategoriaProduto categoriaProdutoCriado = categoriaProdutoUseCase.salvarCategoriaProduto(categoriaProduto);

        return categoriaProdutoPresenter.categoriaProdutoParaCategoriaProdutoResponseDTO(categoriaProdutoCriado);
    }
}
