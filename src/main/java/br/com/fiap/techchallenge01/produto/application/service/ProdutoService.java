package br.com.fiap.techchallenge01.produto.application.service;

import br.com.fiap.techchallenge01.produto.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge01.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge01.produto.domain.repository.ProdutoRepository;
import br.com.fiap.techchallenge01.produto.utils.mapper.ProdutoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final CategoriaProdutoService categoriaProdutoService;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper, CategoriaProdutoService categoriaProdutoService) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
        this.categoriaProdutoService = categoriaProdutoService;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Produto> buscarProdutos() {
        return produtoRepository.buscarProdutos();
    }

    @Override
    @Transactional(readOnly = true)
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.buscarProdutoPorId(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoRequestDTO.getIdCategoria());

        Produto produto = produtoMapper.toProduto(produtoRequestDTO);

        produto = produtoRepository.criarProduto(produto);

        ProdutoResponseDTO produtoResponseDTO = produtoMapper.toResponse(produto);
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }

    @Override
    public ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, Long idProduto) {
        Produto produto = buscarProdutoPorId(idProduto);
        CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoRequestDTO.getIdCategoria());

        Produto produtoParaAtualizar = produtoMapper.toProduto(produtoRequestDTO);
        produtoParaAtualizar.setId(produto.getId());

        Produto produtoSalvo = produtoRepository.atualizarProduto(produtoParaAtualizar);

        ProdutoResponseDTO produtoResponseDTO = produtoMapper.toResponse(produtoSalvo);
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }

    @Override
    public void excluirProduto(Long idProduto) {
        produtoRepository.excluirProduto(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> buscarProdutosPorCategoria(Long idCategoriaProduto) {
        List<Produto> produtos = produtoRepository.buscarProdutosPorCategoria(idCategoriaProduto);
        List<ProdutoResponseDTO> produtosResponseDTO = produtoMapper.toCollectionResponse(produtos);

        produtosResponseDTO.forEach(produtoResponseDTO -> {
            CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoResponseDTO.getCategoriaProduto().getId());
            produtoResponseDTO.setCategoriaProduto(categoriaProduto);
        });

        return produtosResponseDTO;
    }
}
