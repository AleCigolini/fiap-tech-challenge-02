package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final JpaProdutoRepository jpaProdutoRepository;
    private final ModelMapper modelMapper;

    public ProdutoRepositoryImpl(JpaProdutoRepository jpaProdutoRepository, ModelMapper modelMapper) {
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
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return jpaProdutoRepository.findById(id).map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class));
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
    public void excluirProduto(Long idProduto) {
        jpaProdutoRepository.deleteById(idProduto);
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Long idCategoriaProduto) {
        return jpaProdutoRepository.findAllByIdCategoriaOrderByNomeAsc(idCategoriaProduto)
                .stream()
                .map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class))
                .collect(Collectors.toList());
    }
}
