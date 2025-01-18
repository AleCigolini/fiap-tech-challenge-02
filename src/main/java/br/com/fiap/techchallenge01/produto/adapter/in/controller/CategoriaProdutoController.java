package br.com.fiap.techchallenge01.produto.adapter.in.controller;

import br.com.fiap.techchallenge01.produto.adapter.in.controller.api.CategoriaProdutoApi;
import br.com.fiap.techchallenge01.produto.application.usecase.CategoriaProdutoUseCase;
import br.com.fiap.techchallenge01.produto.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge01.produto.utils.mapper.CategoriaProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias-produto")
@RequiredArgsConstructor
public class CategoriaProdutoController implements CategoriaProdutoApi {

    private final CategoriaProdutoMapper categoriaProdutoMapper;
    private final CategoriaProdutoUseCase categoriaProdutoUseCase;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaProdutoResponseDTO buscarCategoriaProduto(@PathVariable String id) {
        return categoriaProdutoMapper.toResponse(categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id));
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaProdutoResponseDTO> listarCategoriasProduto() {
        return categoriaProdutoMapper.toCollectionResponse(categoriaProdutoUseCase.buscarCategoriasProduto());
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaProdutoResponseDTO cadastrarCategoriaProduto(@RequestBody CategoriaProdutoRequestDTO categoriaProdutoRequestDto) {

        CategoriaProduto categoriaProduto = categoriaProdutoMapper.toDomain(categoriaProdutoRequestDto);

        return categoriaProdutoMapper.toResponse(categoriaProdutoUseCase.salvarCategoriaProduto(categoriaProduto));
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaProdutoResponseDTO alterarNomeCategoriaProduto(@PathVariable String id, @RequestBody CategoriaProdutoRequestDTO categoriaProdutoRequestDto) {

        CategoriaProduto categoriaProduto = categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
        categoriaProduto.setNome(categoriaProdutoRequestDto.getNome());

        return categoriaProdutoMapper.toResponse(categoriaProdutoUseCase.alterarNomeCategoriaProduto(id, categoriaProduto));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativarCategoriaProduto(@PathVariable String id) {
        CategoriaProduto categoriaProduto = categoriaProdutoUseCase.buscarCategoriaProdutoPorId(id);
        categoriaProdutoUseCase.desativarCategoriaProduto(categoriaProduto);
    }
}
