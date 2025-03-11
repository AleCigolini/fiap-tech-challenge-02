package br.com.fiap.techchallenge02.produto.adapter.out.adapter;

import br.com.fiap.techchallenge02.produto.adapter.out.jpa.entity.JpaCategoriaProdutoEntity;
import br.com.fiap.techchallenge02.produto.adapter.out.jpa.entity.JpaProdutoEntity;
import br.com.fiap.techchallenge02.produto.adapter.out.jpa.JpaProdutoRepository;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import br.com.fiap.techchallenge02.produto.adapter.out.port.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ProdutoJpaRepositoryImpl implements ProdutoRepository {

    private final JpaProdutoRepository jpaProdutoRepository;
    private final ModelMapper modelMapper;

    public ProdutoJpaRepositoryImpl(JpaProdutoRepository jpaProdutoRepository, ModelMapper modelMapper) {
        this.jpaProdutoRepository = jpaProdutoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Produto> buscarProdutos() {
        return jpaProdutoRepository.findAllByOrderByNomeAsc()
                .stream()
                .map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(String id) {
        return jpaProdutoRepository.findById(UUID.fromString(id)).map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class));
    }

    @Override
    public Produto criarProduto(Produto produto) {
        JpaProdutoEntity jpaProdutoEntity = modelMapper.map(produto, JpaProdutoEntity.class);

        JpaProdutoEntity jpaProdutoEntitySalvo = jpaProdutoRepository.save(jpaProdutoEntity);

        return modelMapper.map(jpaProdutoEntitySalvo, Produto.class);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        JpaProdutoEntity jpaProdutoEntity = modelMapper.map(produto, JpaProdutoEntity.class);

        JpaProdutoEntity jpaProdutoEntitySalvo = jpaProdutoRepository.save(jpaProdutoEntity);

        return modelMapper.map(jpaProdutoEntitySalvo, Produto.class);
    }

    @Override
    public void excluirProduto(String id) {
        jpaProdutoRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(String idCategoriaProduto) {
        JpaCategoriaProdutoEntity categoria = new JpaCategoriaProdutoEntity();
        categoria.setId(UUID.fromString(idCategoriaProduto));

        return jpaProdutoRepository.findAllByCategoriaOrderByNomeAsc(categoria)
                .stream()
                .map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class))
                .collect(Collectors.toList());
    }
}
