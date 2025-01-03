package br.com.fiap.techchallenge01.produto.adapter.in.controller.api;

import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URISyntaxException;
import java.util.List;

@Tag(name = "API de acompanhamentos")
public interface ProdutoApi {

    /**
     * Busca todos os produtos
     *
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Buscar todos os produtos")
    ResponseEntity<List<ProdutoResponseDTO>> buscarProdutos();

    /**
     * Busca produto por ID
     *
     * @param id Long do produto
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Buscar produto por ID")
    ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(Long id);

    /**
     * Criar produto
     *
     * @param produtoRequestDTO DTO para criação de produto
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Criar novo produto")
    ResponseEntity<ProdutoResponseDTO> criarProduto(ProdutoRequestDTO produtoRequestDTO) throws URISyntaxException;
}