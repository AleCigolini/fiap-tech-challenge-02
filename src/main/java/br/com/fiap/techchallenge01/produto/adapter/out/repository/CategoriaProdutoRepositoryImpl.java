package br.com.fiap.techchallenge01.produto.adapter.out.repository;

import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.repository.CategoriaProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoriaProdutoRepositoryImpl implements CategoriaProdutoRepository {

    private final JpaCategoriaProdutoRepository jpaCategoriaProdutoRepository;
    private final ModelMapper modelMapper;

    public CategoriaProdutoRepositoryImpl(JpaCategoriaProdutoRepository jpaCategoriaProdutoRepository, ModelMapper modelMapper) {
        this.jpaCategoriaProdutoRepository = jpaCategoriaProdutoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<CategoriaProduto> buscarCategoriaProdutoPorId(Long idCategoriaProduto) {
        return jpaCategoriaProdutoRepository.findById(idCategoriaProduto).map(jpaCategoriaProdutoEntity -> modelMapper.map(jpaCategoriaProdutoEntity, CategoriaProduto.class));
    }
}
