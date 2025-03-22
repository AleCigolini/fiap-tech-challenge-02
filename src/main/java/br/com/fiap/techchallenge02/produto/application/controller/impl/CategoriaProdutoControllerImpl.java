package br.com.fiap.techchallenge02.produto.application.controller.impl;

import br.com.fiap.techchallenge02.produto.application.controller.CategoriaProdutoController;
import br.com.fiap.techchallenge02.produto.application.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.gateway.impl.CategoriaProdutoGatewayImpl;
import br.com.fiap.techchallenge02.produto.application.mapper.CategoriaProdutoMapper;
import br.com.fiap.techchallenge02.produto.application.mapper.impl.CategoriaProdutoMapperImpl;
import br.com.fiap.techchallenge02.produto.application.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto.application.presenter.impl.CategoriaProdutoModelMapperPresenterImpl;
import br.com.fiap.techchallenge02.produto.application.usecase.BuscarCategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.application.usecase.SalvarCategoriaProdutoUseCase;
import br.com.fiap.techchallenge02.produto.application.usecase.impl.BuscarCategoriaProdutoUseCaseImpl;
import br.com.fiap.techchallenge02.produto.application.usecase.impl.SalvarCategoriaProdutoUseCaseImpl;
import br.com.fiap.techchallenge02.produto.common.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.common.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.infrastructure.database.adpater.CategoriaProdutoDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaProdutoControllerImpl implements CategoriaProdutoController {

    private final SalvarCategoriaProdutoUseCase salvarCategoriaProdutoUseCase;
    private final BuscarCategoriaProdutoUseCase buscarCategoriaProdutoUseCase;
    private final CategoriaProdutoPresenter categoriaProdutoPresenter;
    private final CategoriaProdutoMapper categoriaProdutoMapper;

    public CategoriaProdutoControllerImpl(ModelMapper modelMapper, CategoriaProdutoDatabase categoriaProdutoDatabase) {
        this.categoriaProdutoPresenter = new CategoriaProdutoModelMapperPresenterImpl(modelMapper);
        this.categoriaProdutoMapper = new CategoriaProdutoMapperImpl(modelMapper);
        final CategoriaProdutoGateway categoriaProdutoGateway = new CategoriaProdutoGatewayImpl(categoriaProdutoDatabase, categoriaProdutoMapper);
        this.salvarCategoriaProdutoUseCase = new SalvarCategoriaProdutoUseCaseImpl(categoriaProdutoGateway);
        this.buscarCategoriaProdutoUseCase = new BuscarCategoriaProdutoUseCaseImpl(categoriaProdutoGateway);
    }

    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        return buscarCategoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
    }

    public List<CategoriaProdutoResponseDTO> buscarCategoriasProduto() {
        List<CategoriaProduto> categoriaProdutos = buscarCategoriaProdutoUseCase.buscarCategoriasProduto();

        return categoriaProdutoPresenter.categoriasProdutoParaCategoriasProdutoResponseDTO(categoriaProdutos);
    }

    @Override
    public CategoriaProdutoResponseDTO criarCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoMapper.categoriaProdutoRequestDTOParaCategoriaProduto(categoriaProdutoRequestDTO);
        CategoriaProduto categoriaProdutoCriado = salvarCategoriaProdutoUseCase.salvarCategoriaProduto(categoriaProduto);

        return categoriaProdutoPresenter.categoriaProdutoParaCategoriaProdutoResponseDTO(categoriaProdutoCriado);
    }
}
