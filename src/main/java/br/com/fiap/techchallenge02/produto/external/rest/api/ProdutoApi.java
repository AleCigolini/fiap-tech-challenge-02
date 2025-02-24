package br.com.fiap.techchallenge02.produto.external.rest.api;

import br.com.fiap.techchallenge02.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge02.produto.domain.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

@Tag(name = "${tag.swagger.produto.name}", description = "${tag.swagger.produto.description}")
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
    ResponseEntity<List<ProdutoResponseDTO>> buscarProdutosPorCategoria(String idCategoriaProduto);

    /**
     * Busca produto por ID
     *
     * @param id Long do produto
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Buscar produto por ID")
    ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(String id);

    /**
     * Criar produto
     *
     * @param produtoRequestDTO DTO para criação de produto
     * @return {@link ProdutoResponseDTO}
     */
    @Operation(summary = "Criar novo produto")
    ResponseEntity<ProdutoResponseDTO> criarProduto(ProdutoRequestDTO produtoRequestDTO) throws URISyntaxException;

//    /**
//     * Atualizar produto
//     *
//     * @param produtoRequestDTO DTO para atualização de produto
//     * @param id ID do produto a ser atualizado
//     * @return {@link ProdutoResponseDTO}
//     */
//    @Operation(summary = "Atualizar um produto")
//    ResponseEntity<ProdutoResponseDTO> atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String id);
//
//    /**
//     * Excluir um produto
//     *
//     * @param id ID do produto a ser excluído
//     * @return void
//     */
//    @Operation(summary = "Excluir um produto")
//    ResponseEntity<Void> excluirProduto(String id);
}