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
        return jpaProdutoRepository.findAll()
                .stream()
                .map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return jpaProdutoRepository.findById(id).map(jpaProdutoEntity -> modelMapper.map(jpaProdutoEntity, Produto.class));
    }
}
