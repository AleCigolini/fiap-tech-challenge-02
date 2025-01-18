package br.com.fiap.techchallenge01.produto.utils.mapper;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.CategoriaProdutoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaProdutoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaProdutoResponseDTO toResponse(CategoriaProduto categoriaProduto) {
        return modelMapper.map(categoriaProduto, CategoriaProdutoResponseDTO.class);
    }

    public List<CategoriaProdutoResponseDTO> toCollectionResponse(List<CategoriaProduto> categoriaProdutos) {
        return categoriaProdutos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public CategoriaProduto toDomain(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO) {
        return modelMapper.map(categoriaProdutoRequestDTO, CategoriaProduto.class);
    }

}
