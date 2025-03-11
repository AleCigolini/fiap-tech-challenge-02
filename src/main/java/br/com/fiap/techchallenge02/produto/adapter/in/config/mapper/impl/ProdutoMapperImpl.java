package br.com.fiap.techchallenge02.produto.adapter.in.config.mapper.impl;

import br.com.fiap.techchallenge02.produto.adapter.in.config.mapper.ProdutoMapper;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProdutoMapperImpl implements ProdutoMapper {
    private final ModelMapper modelMapper;

    @Override
    public Produto produtoRequestDtoParaProduto(ProdutoRequestDTO produtoRequestDTO) {
        modelMapper.typeMap(ProdutoRequestDTO.class, Produto.class).addMappings(mapper -> mapper.skip(Produto::setId));

        return modelMapper.map(produtoRequestDTO, Produto.class);
    }
}
