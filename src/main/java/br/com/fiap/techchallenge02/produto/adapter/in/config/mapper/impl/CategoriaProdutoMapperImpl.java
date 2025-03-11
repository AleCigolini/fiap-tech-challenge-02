package br.com.fiap.techchallenge02.produto.adapter.in.config.mapper.impl;

import br.com.fiap.techchallenge02.produto.adapter.in.config.mapper.CategoriaProdutoMapper;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.domain.dto.request.CategoriaProdutoRequestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoriaProdutoMapperImpl implements CategoriaProdutoMapper {

    private final ModelMapper modelMapper;

    @Override
    public CategoriaProduto categoriaProdutoRequestDTOParaCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO) {
        return modelMapper.map(categoriaProdutoRequestDTO, CategoriaProduto.class);
    }
}
