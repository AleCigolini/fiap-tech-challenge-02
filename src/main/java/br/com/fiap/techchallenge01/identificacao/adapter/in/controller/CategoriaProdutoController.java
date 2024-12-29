package br.com.fiap.techchallenge01.identificacao.adapter.in.controller;

import br.com.fiap.techchallenge01.identificacao.adapter.in.controller.api.CategoriaProdutoApi;
import br.com.fiap.techchallenge01.identificacao.application.service.CategoriaProdutoService;
import br.com.fiap.techchallenge01.identificacao.domain.CategoriaProduto;
import br.com.fiap.techchallenge01.identificacao.domain.dto.request.CategoriaProdutoRequestDTO;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.CategoriaProdutoResponseDTO;
import br.com.fiap.techchallenge01.identificacao.utils.mapper.CategoriaProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias-produto")
public class CategoriaProdutoController implements CategoriaProdutoApi {

    @Autowired
    private CategoriaProdutoMapper categoriaProdutoMapper;

    @Autowired
    private CategoriaProdutoService acompanhamentoService;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaProdutoResponseDTO buscarCategoriaProduto(@PathVariable Long id) {
        return categoriaProdutoMapper.toResponse(acompanhamentoService.buscarCategoriaProdutoPorId(id));
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaProdutoResponseDTO> listarCategoriasProduto() {
        return categoriaProdutoMapper.toCollectionResponse(acompanhamentoService.buscarCategoriasProduto());
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaProdutoResponseDTO cadastrarCategoriaProduto(@RequestBody CategoriaProdutoRequestDTO categoriaProdutoRequestDto) {

        CategoriaProduto categoriaProduto = categoriaProdutoMapper.toDomain(categoriaProdutoRequestDto);

        return categoriaProdutoMapper.toResponse(acompanhamentoService.salvarCategoriaProduto(categoriaProduto));
    }
}
