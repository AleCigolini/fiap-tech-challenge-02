package br.com.fiap.techchallenge02.produto.external.repository;

import br.com.fiap.techchallenge02.produto.adapter.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.adapter.presenter.ProdutoPresenter;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.external.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.external.entity.JpaProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProdutoJpaGatewayImpl implements ProdutoGateway {

    private final ProdutoJpaRepository produtoJpaRepository;
    private final ProdutoPresenter produtoPresenter;

    public ProdutoJpaGatewayImpl(ProdutoJpaRepository produtoJpaRepository, ProdutoPresenter produtoPresenter) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.produtoPresenter = produtoPresenter;
    }

    @Override
    public List<Produto> buscarProdutos() {
        List<JpaProdutoEntity> jpaProdutoEntities = produtoJpaRepository.findAllByOrderByNomeAsc();
        return produtoPresenter.jpaProdutoEntitiesParaProdutos(jpaProdutoEntities);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        JpaCategoriaProdutoEntity categoria = new JpaCategoriaProdutoEntity();
        categoria.setId(UUID.fromString(idCategoriaProduto));

        List<JpaProdutoEntity> jpaProdutoEntities = produtoJpaRepository.findAllByCategoriaOrderByNomeAsc(categoria);

        return produtoPresenter.jpaProdutoEntitiesParaProdutos(jpaProdutoEntities);
    }
}
