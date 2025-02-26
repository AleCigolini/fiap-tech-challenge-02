package br.com.fiap.techchallenge02.produto.external.rest;

import br.com.fiap.techchallenge02.produto.adapter.controller.CategoriaProdutoController;
import br.com.fiap.techchallenge02.produto.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge02.produto.external.rest.api.CategoriaProdutoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/categorias-produto")
@RequiredArgsConstructor
public class CategoriaProdutoRest implements CategoriaProdutoApi {

    private final CategoriaProdutoController categoriaProdutoController;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProdutoResponseDTO> buscarCategoriaProduto(@PathVariable String id) {
        CategoriaProdutoResponseDTO categoriaProdutoResponseDTO = categoriaProdutoController.buscarCategoriaProdutoResponseDTOPorId(id);

        return ResponseEntity.ok(categoriaProdutoResponseDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoriaProdutoResponseDTO>> buscarCategoriasProduto() {
        List<CategoriaProdutoResponseDTO> categoriasProdutoResponseDTO = categoriaProdutoController.buscarCategoriasProduto();

        return ResponseEntity.ok(categoriasProdutoResponseDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<CategoriaProdutoResponseDTO> criarCategoriaProduto(@RequestBody CategoriaProdutoRequestDTO categoriaProdutoRequestDto) throws URISyntaxException {
        CategoriaProdutoResponseDTO categoriaProdutoResponseDTO = categoriaProdutoController.criarCategoriaProduto(categoriaProdutoRequestDto);

        return ResponseEntity.created(new URI("/categorias-produto/" + categoriaProdutoResponseDTO.getId())).body(categoriaProdutoResponseDTO);
    }
}
