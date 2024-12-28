package br.com.fiap.techchallenge01.produto.adapter.in.controller.api;

import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

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
}