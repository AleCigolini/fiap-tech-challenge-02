package br.com.fiap.techchallenge02.produto.external.repository;

import br.com.fiap.techchallenge02.produto.adapter.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto.adapter.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto.external.entity.JpaCategoriaProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoriaProdutoJpaGatewayImpl implements CategoriaProdutoGateway {

    private final CategoriaProdutoJpaRepository categoriaProdutoJpaRepository;
    private final CategoriaProdutoPresenter categoriaProdutoPresenter;

    public CategoriaProdutoJpaGatewayImpl(CategoriaProdutoJpaRepository categoriaProdutoJpaRepository, CategoriaProdutoPresenter categoriaProdutoPresenter) {
        this.categoriaProdutoJpaRepository = categoriaProdutoJpaRepository;
        this.categoriaProdutoPresenter = categoriaProdutoPresenter;
    }


    @Override
    public CategoriaProduto buscarCategoriaProdutoPorId(String id) {
        Optional<JpaCategoriaProdutoEntity> jpaCategoriaProdutoEntity = categoriaProdutoJpaRepository.findById(UUID.fromString(id))
                .filter(JpaCategoriaProdutoEntity::getAtivo);

        return jpaCategoriaProdutoEntity.map(categoriaProdutoPresenter::jpaCategoriaProdutoEntityParaCategoriaProduto).orElse(null);
    }
}
