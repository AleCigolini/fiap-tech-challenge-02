package br.com.fiap.techchallenge01.produto.utils.mapper;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoMapper {

    private final ModelMapper modelMapper;

    public ProdutoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProdutoResponseDTO toResponse(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDTO.class);
    }

    public List<ProdutoResponseDTO> toCollectionResponse(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Produto toProduto(ProdutoRequestDTO produtoRequestDTO) {
        modelMapper.typeMap(ProdutoRequestDTO.class, Produto.class).addMappings(mapper -> {
            mapper.skip(Produto::setId);
        });

        Produto produto = modelMapper.map(produtoRequestDTO, Produto.class);


        return produto;
    }
}
