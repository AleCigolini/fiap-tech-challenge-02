package br.com.fiap.techchallenge02.produto.adapter.presenter;

import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.external.entity.JpaCategoriaProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
}
