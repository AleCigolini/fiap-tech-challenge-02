package br.com.fiap.techchallenge01.produto.adapter.in.controller;

import br.com.fiap.techchallenge01.produto.adapter.in.controller.api.ProdutoApi;
import br.com.fiap.techchallenge01.produto.adapter.out.exception.ProdutoNaoEncontradoException;
import br.com.fiap.techchallenge01.produto.application.service.ProdutoService;
import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge01.produto.utils.mapper.ProdutoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController implements ProdutoApi {

    private final ProdutoService produtoService;
    private final ProdutoMapper produtoMapper;

    public ProdutoController(ProdutoService produtoService, ProdutoMapper produtoMapper) {
        this.produtoService = produtoService;
        this.produtoMapper = produtoMapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutos() {
        List<Produto> produtos = produtoService.buscarProdutos();

        return ResponseEntity.ok(produtoMapper.toCollectionResponse(produtos));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);

        return ResponseEntity.ok(produtoMapper.toResponse(produto));
    }

    @Override
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) throws URISyntaxException {
        ProdutoResponseDTO produtoResponse = produtoService.criarProduto(produtoRequestDTO);

        return ResponseEntity.created(new URI(STR."/produtos/\{produtoResponse.getId()}")).body(produtoResponse);
    }

    @Override
    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO, @PathVariable Long idProduto) {
        ProdutoResponseDTO produtoResponse = produtoService.atualizarProduto(produtoRequestDTO, idProduto);

        return ResponseEntity.ok(produtoResponse);
    }
}
