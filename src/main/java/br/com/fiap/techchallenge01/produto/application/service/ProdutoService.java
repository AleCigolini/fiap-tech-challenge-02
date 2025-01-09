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
    public List<ProdutoResponseDTO> buscarProdutos() {
        List<Produto> produtos = produtoRepository.buscarProdutos();

        List<ProdutoResponseDTO> produtosResponseDTO = produtoMapper.toCollectionResponse(produtos);
        produtosResponseDTO.forEach(produtoResponseDTO -> {
            CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoResponseDTO.getCategoriaProduto().getId());
            produtoResponseDTO.setCategoriaProduto(categoriaProduto);
        });

        return produtosResponseDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarProdutoPorId(String id) {
        Produto produto = produtoRepository.buscarProdutoPorId(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
        ProdutoResponseDTO produtoResponseDTO = produtoMapper.toResponse(produto);

        CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoResponseDTO.getCategoriaProduto().getId());
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }

    // TODO: ALINHAR EM GRUPO O RETORNO DO OBJ OU DO DTO NA CAMADA DE SERVIÇO PRA SER USADO EM OUTROS SERVIÇOS DA MESMA CAMADA
    @Override
    @Transactional(readOnly = true)
    public Produto obterProdutoPorId(String id) {
        Produto produto = produtoRepository.buscarProdutoPorId(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
//        ProdutoResponseDTO produtoResponseDTO = produtoMapper.toResponse(produto);

//        TODO: CONVERTER EM ANOTAÇÃO ONE:MANY
//        CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoResponseDTO.getCategoriaProduto().getId());
//        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produto;
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
    public ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String idProduto) {
        ProdutoResponseDTO produtoResponseDTO = buscarProdutoPorId(idProduto);
        CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoRequestDTO.getIdCategoria());

        Produto produtoParaAtualizar = produtoMapper.toProduto(produtoRequestDTO);
        produtoParaAtualizar.setId(produtoResponseDTO.getId());

        Produto produtoSalvo = produtoRepository.atualizarProduto(produtoParaAtualizar);

        produtoResponseDTO = produtoMapper.toResponse(produtoSalvo);
        produtoResponseDTO.setCategoriaProduto(categoriaProduto);

        return produtoResponseDTO;
    }

    @Override
    public void excluirProduto(String idProduto) {
        produtoRepository.excluirProduto(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> buscarProdutosPorCategoria(String idCategoriaProduto) {
        List<Produto> produtos = produtoRepository.buscarProdutosPorCategoria(idCategoriaProduto);
        List<ProdutoResponseDTO> produtosResponseDTO = produtoMapper.toCollectionResponse(produtos);

        produtosResponseDTO.forEach(produtoResponseDTO -> {
            CategoriaProduto categoriaProduto = categoriaProdutoService.buscarCategoriaProdutoPorId(produtoResponseDTO.getCategoriaProduto().getId());
            produtoResponseDTO.setCategoriaProduto(categoriaProduto);
        });

        return produtosResponseDTO;
    }
}
