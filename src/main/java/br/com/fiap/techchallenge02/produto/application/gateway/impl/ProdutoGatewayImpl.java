package br.com.fiap.techchallenge02.produto.application.gateway.impl;

import br.com.fiap.techchallenge02.produto.application.gateway.ProdutoGateway;
import br.com.fiap.techchallenge02.produto.application.mapper.ProdutoMapper;
import br.com.fiap.techchallenge02.produto.common.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.common.entity.JpaProdutoEntity;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.infrastructure.database.adpater.ProdutoDatabase;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ProdutoGatewayImpl implements ProdutoGateway {

    private final ProdutoDatabase produtoDatabase;
    private final ProdutoMapper produtoMapper;

    public ProdutoGatewayImpl(ProdutoDatabase produtoDatabase, ProdutoMapper produtoMapper) {
        this.produtoDatabase = produtoDatabase;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoDatabase.findAllByOrderByNomeAsc()
                .stream()
                .map(produtoMapper::jpaProdutoEntityParaProduto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(String id) {
        return produtoDatabase.findById(UUID.fromString(id)).map(produtoMapper::jpaProdutoEntityParaProduto);
    }

    @Override
    public Produto criarProduto(Produto produto) {
        JpaProdutoEntity jpaProdutoEntity = produtoMapper.produtoParaJpaProdutoEntity(produto);

        JpaProdutoEntity jpaProdutoEntitySalvo = produtoDatabase.save(jpaProdutoEntity);

        return produtoMapper.jpaProdutoEntityParaProduto(jpaProdutoEntitySalvo);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        JpaProdutoEntity jpaProdutoEntity = produtoMapper.produtoParaJpaProdutoEntity(produto);

        JpaProdutoEntity jpaProdutoEntitySalvo = produtoDatabase.save(jpaProdutoEntity);

        return produtoMapper.jpaProdutoEntityParaProduto(jpaProdutoEntitySalvo);
    }

    @Override
    public void excluirProduto(String id) {
        produtoDatabase.deleteById(UUID.fromString(id));
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        JpaCategoriaProdutoEntity categoria = new JpaCategoriaProdutoEntity();
        categoria.setId(UUID.fromString(idCategoriaProduto));

        return produtoDatabase.findAllByCategoriaOrderByNomeAsc(categoria)
                .stream()
                .map(produtoMapper::jpaProdutoEntityParaProduto)
                .collect(Collectors.toList());
    }
}
