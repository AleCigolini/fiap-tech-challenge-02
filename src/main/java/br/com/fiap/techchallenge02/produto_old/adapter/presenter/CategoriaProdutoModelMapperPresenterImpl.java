package br.com.fiap.techchallenge02.produto_old.adapter.presenter;

import br.com.fiap.techchallenge02.produto_old.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto_old.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto_old.domain.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto_old.external.entity.JpaCategoriaProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaProdutoModelMapperPresenterImpl implements CategoriaProdutoPresenter {

    private final ModelMapper modelMapper;

    public CategoriaProdutoModelMapperPresenterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoriaProduto jpaCategoriaProdutoEntityParaCategoriaProduto(JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity) {
        return modelMapper.map(jpaCategoriaProdutoEntity, CategoriaProduto.class);
    }

    @Override
    public CategoriaProdutoResponseDTO categoriaProdutoParaCategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto) {
        return modelMapper.map(categoriaProduto, CategoriaProdutoResponseDTO.class);
    }

    @Override
    public List<CategoriaProdutoResponseDTO> categoriasProdutoParaCategoriasProdutoResponseDTO(List<CategoriaProduto> categoriasProduto) {
        return categoriasProduto.stream().map(categoriaProduto -> modelMapper.map(categoriaProduto, CategoriaProdutoResponseDTO.class)).toList();
    }

    @Override
    public CategoriaProduto categoriaProdutoRequestDTOParaCategoriaProduto(CategoriaProdutoRequestDTO categoriaProdutoRequestDTO) {
        return modelMapper.map(categoriaProdutoRequestDTO, CategoriaProduto.class);
    }

    @Override
    public JpaCategoriaProdutoEntity categoriaProdutoParaJpaCategoriaProdutoEntity(CategoriaProduto categoriaProduto) {
        return modelMapper.map(categoriaProduto, JpaCategoriaProdutoEntity.class);
    }
}
