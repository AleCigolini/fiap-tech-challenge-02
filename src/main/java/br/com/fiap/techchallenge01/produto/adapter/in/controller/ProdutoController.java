package br.com.fiap.techchallenge01.produto.adapter.in.controller;

import br.com.fiap.techchallenge01.produto.adapter.in.controller.api.ProdutoApi;
import br.com.fiap.techchallenge01.produto.application.usecase.ProdutoUseCase;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController implements ProdutoApi {

    private final ProdutoUseCase produtoUseCase;

    @Override
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutos() {
        List<ProdutoResponseDTO> produtosResponseDTO = produtoUseCase.buscarProdutos();

        return ResponseEntity.ok(produtosResponseDTO);
    }

    @Override
    @GetMapping("/categoria/{idCategoriaProduto}")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutosPorCategoria(@PathVariable String idCategoriaProduto) {
        List<ProdutoResponseDTO> produtosResponse = produtoUseCase.buscarProdutosPorCategoria(idCategoriaProduto);

        return ResponseEntity.ok(produtosResponse);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable String id) {
        ProdutoResponseDTO produtoResponseDTO = produtoUseCase.buscarProdutoPorId(id);

        return ResponseEntity.ok(produtoResponseDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) throws URISyntaxException {
        ProdutoResponseDTO produtoResponse = produtoUseCase.criarProduto(produtoRequestDTO);

        return ResponseEntity.created(new URI("/produtos/" + produtoResponse.getId())).body(produtoResponse);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO, @PathVariable String id) {
        ProdutoResponseDTO produtoResponse = produtoUseCase.atualizarProduto(produtoRequestDTO, id);

        return ResponseEntity.ok(produtoResponse);
    }

    @Override
    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String idProduto) {
        produtoUseCase.excluirProduto(idProduto);
        return ResponseEntity.ok().build();
    }
}
