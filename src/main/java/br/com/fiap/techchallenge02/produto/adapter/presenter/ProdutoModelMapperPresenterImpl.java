package br.com.fiap.techchallenge02.produto.adapter.presenter;

import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.external.entity.JpaProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoModelMapperPresenterImpl implements ProdutoPresenter {

    private final ModelMapper modelMapper;

    public ProdutoModelMapperPresenterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Produto> jpaProdutoEntitiesParaProdutos(List<JpaProdutoEntity> jpaProdutoEntities) {
        return jpaProdutoEntities.stream().map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> produtosParaProdutosResponseDTO(List<Produto> produtos) {
        return produtos.stream().map(produto -> modelMapper.map(produto, ProdutoResponseDTO.class)).toList();
    }

    @Override
    public Produto jpaProdutoEntityParaProduto(JpaProdutoEntity jpaProdutoEntity) {
        return modelMapper.map(jpaProdutoEntity, Produto.class);
    }

    @Override
    public ProdutoResponseDTO produtoParaProdutoResponseDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDTO.class);
    }

    @Override
    public Produto produtoRequestDtoParaProduto(ProdutoRequestDTO produtoRequestDTO) {
        modelMapper.typeMap(ProdutoRequestDTO.class, Produto.class).addMappings(mapper -> mapper.skip(Produto::setId));

        return modelMapper.map(produtoRequestDTO, Produto.class);
    }

    @Override
    public JpaProdutoEntity produtoParaJpaProdutoEntity(Produto produto) {
        return modelMapper.map(produto, JpaProdutoEntity.class);
    }
}
