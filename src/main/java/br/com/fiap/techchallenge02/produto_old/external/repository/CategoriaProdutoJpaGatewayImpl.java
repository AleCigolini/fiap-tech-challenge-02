package br.com.fiap.techchallenge02.produto_old.external.repository;

import br.com.fiap.techchallenge02.produto_old.adapter.gateway.CategoriaProdutoGateway;
import br.com.fiap.techchallenge02.produto_old.adapter.presenter.CategoriaProdutoPresenter;
import br.com.fiap.techchallenge02.produto_old.domain.CategoriaProduto;
import br.com.fiap.techchallenge02.produto_old.external.entity.JpaCategoriaProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public List<CategoriaProduto> buscarCategoriasProduto() {
        List<JpaCategoriaProdutoEntity> jpaCategoriaProdutoEntities = categoriaProdutoJpaRepository.findByAtivoTrue();

        return jpaCategoriaProdutoEntities.stream().map(categoriaProdutoPresenter::jpaCategoriaProdutoEntityParaCategoriaProduto).toList();
    }

    @Override
    public CategoriaProduto criarCategoriaProduto(CategoriaProduto categoriaProduto) {
        JpaCategoriaProdutoEntity jpaCategoriaProdutoEntity = categoriaProdutoPresenter.categoriaProdutoParaJpaCategoriaProdutoEntity(categoriaProduto);
        JpaCategoriaProdutoEntity jpaCategoriaProdutoEntitySalvo = categoriaProdutoJpaRepository.save(jpaCategoriaProdutoEntity);

        return categoriaProdutoPresenter.jpaCategoriaProdutoEntityParaCategoriaProduto(jpaCategoriaProdutoEntitySalvo);
    }
}
