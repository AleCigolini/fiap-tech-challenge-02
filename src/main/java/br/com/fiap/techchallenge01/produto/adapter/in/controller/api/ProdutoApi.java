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

@Tag(name = "Produtos")
public interface ProdutoApi {

    /**
     * Busca todos os produtos
     *
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Buscar todos os produtos")
    ResponseEntity<List<ProdutoResponseDTO>> buscarProdutos();

    /**
     * Busca os produtos por categoria
     *
     * @param idCategoriaProduto Long da categoria produto
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Buscar os produtos por categoria")
    ResponseEntity<List<ProdutoResponseDTO>> buscarProdutosPorCategoria(Long idCategoriaProduto);

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

    /**
     * Atualizar produto
     *
     * @param produtoRequestDTO DTO para atualização de produto
     * @param idProduto ID do produto a ser atualizado
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Atualizar um produto")
    ResponseEntity<ProdutoResponseDTO> atualizarProduto(ProdutoRequestDTO produtoRequestDTO, Long idProduto);

    /**
     * Excluir um produto
     *
     * @param idProduto ID do produto a ser excluído
     * @return void
     */
    @Operation(summary = "Excluir um produto")
    ResponseEntity<Void> excluirProduto(Long idProduto);
}