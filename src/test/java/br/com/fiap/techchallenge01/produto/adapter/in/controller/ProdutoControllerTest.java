package br.com.fiap.techchallenge01.produto.adapter.in.controller;

import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge01.utils.JsonHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTest {

    private static final String PRODUTOS_URL_PADRAO = "/produtos";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    void deveBuscarTodosProdutos() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get(PRODUTOS_URL_PADRAO))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        ProdutoResponseDTO[] produtos = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO[].class);

        assertThat(produtos).isNotNull();
        assertThat(produtos.length).isEqualTo(3);
    }

    @Test
    @Transactional
    void deveBuscarProdutosPorCategoria() throws Exception {
        long idCategoriaProduto = 1L;

        MockHttpServletResponse response = mockMvc.perform(
                        get(PRODUTOS_URL_PADRAO + "/categoria/" + idCategoriaProduto)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse();

        ProdutoResponseDTO[] produtosResponse = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO[].class);

        assertThat(produtosResponse).isNotNull();
        assertThat(produtosResponse)
                .allMatch(produtoResponse -> produtoResponse.getCategoriaProduto().getId().equals(idCategoriaProduto));
    }

    @Test
    @Transactional
    void deveBuscarProdutoPorId() throws Exception {
        long idProduto = 1L;

        MockHttpServletResponse response = mockMvc.perform(get(PRODUTOS_URL_PADRAO + "/" + idProduto))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        ProdutoResponseDTO produto = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO.class);

        assertThat(produto).isNotNull();
        assertThat(produto.getId()).isEqualTo(idProduto);
        assertThat(produto.getNome()).isEqualTo("Hamburguer");
        assertThat(produto.getDescricao()).isEqualTo("Pão, queijo, alface, tomate, carne.");
    }

    @Test
    @Transactional
    void deveCriarProduto() throws Exception {
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();

        MockHttpServletResponse response = mockMvc.perform(
                post(PRODUTOS_URL_PADRAO)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isCreated())
                .andReturn().getResponse();

        ProdutoResponseDTO produto = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO.class);

        assertThat(produto).isNotNull();
        assertThat(produto.getId()).isNotNull();
        assertThat(produto.getNome()).isEqualTo(produtoRequestDTO.getNome());
        assertThat(produto.getDescricao()).isEqualTo(produtoRequestDTO.getDescricao());
        assertThat(produto.getCategoriaProduto()).isNotNull();
        assertThat(produto.getCategoriaProduto().getId()).isEqualTo(produtoRequestDTO.getIdCategoria());
        assertThat(produto.getCategoriaProduto().getNome()).isEqualTo("Acompanhamento");
    }

    @Test
    @Transactional
    void naoDeveCriarProdutoQuandoNaoEncontrarCategoriaProduto() throws Exception {
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setIdCategoria(999L);

        mockMvc.perform(
                        post(PRODUTOS_URL_PADRAO)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(
                        status().isNotFound()
                );
    }

    @Test
    @Transactional
    void naoDeveCriarProdutoQuandoONomeDoProdutoEstiverVazio() throws Exception {
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setNome("");

        mockMvc.perform(
                        post(PRODUTOS_URL_PADRAO)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(
                        status().isBadRequest()
                );
    }

    @Test
    @Transactional
    void naoDeveCriarProdutoQuandoADescricaoDoProdutoEstiverVazia() throws Exception {
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setDescricao("");

        mockMvc.perform(
                        post(PRODUTOS_URL_PADRAO)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(
                        status().isBadRequest()
                );
    }

    @Test
    @Transactional
    void naoDeveCriarProdutoQuandoOIdCategoriaDoProdutoEstiverNula() throws Exception {
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setIdCategoria(null);

        mockMvc.perform(
                        post(PRODUTOS_URL_PADRAO)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(
                        status().isBadRequest()
                );
    }

    @Test
    @Transactional
    void naoDeveCriarProdutoQuandoOPrecoDoProdutoEstiverNulo() throws Exception {
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setIdCategoria(null);

        mockMvc.perform(
                        post(PRODUTOS_URL_PADRAO)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(
                        status().isBadRequest()
                );
    }

    @Test
    @Transactional
    void deveAtualizarProduto() throws Exception {
        Long idProduto = 1L;
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setNome("Nome atualizado");
        produtoRequestDTO.setPreco(40.00);

        MockHttpServletResponse response = mockMvc.perform(
                        put(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isOk())
                .andReturn().getResponse();

        ProdutoResponseDTO produtoResponse = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO.class);

        assertThat(produtoResponse).isNotNull();
        assertThat(produtoResponse.getId()).isNotNull();
        assertThat(produtoResponse.getId()).isEqualTo(idProduto);
        assertThat(produtoResponse.getNome()).isEqualTo(produtoRequestDTO.getNome());
        assertThat(produtoResponse.getDescricao()).isEqualTo(produtoRequestDTO.getDescricao());
        assertThat(produtoResponse.getCategoriaProduto()).isNotNull();
        assertThat(produtoResponse.getCategoriaProduto().getId()).isEqualTo(produtoRequestDTO.getIdCategoria());
        assertThat(produtoResponse.getCategoriaProduto().getNome()).isEqualTo("Acompanhamento");
    }

    @Test
    @Transactional
    void naoDeveAtualizarOProdutoQuandoNaoEncontrarOProduto() throws Exception {
        Long idProduto = 9999L;
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setNome("Nome atualizado");
        produtoRequestDTO.setPreco(40.00);

        mockMvc.perform(
                        put(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void naoDeveAtualizarOProdutoQuandoONomeDoProdutoEstiverVazio() throws Exception {
        Long idProduto = 9999L;
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setNome("");

        mockMvc.perform(
                        put(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void naoDeveAtualizarOProdutoQuandoADescricaoDoProdutoEstiverVazia() throws Exception {
        Long idProduto = 9999L;
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setDescricao("");

        mockMvc.perform(
                        put(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void naoDeveAtualizarOProdutoQuandoOIdCategoriaDoProdutoEstiverNulo() throws Exception {
        Long idProduto = 9999L;
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setIdCategoria(null);

        mockMvc.perform(
                        put(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void naoDeveAtualizarOProdutoQuandoOPrecoDoProdutoEstiverNulo() throws Exception {
        Long idProduto = 9999L;
        ProdutoRequestDTO produtoRequestDTO = montarProdutoRequestDTO();
        produtoRequestDTO.setPreco(null);

        mockMvc.perform(
                        put(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonHelper.toJson(produtoRequestDTO))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void deveExcluirProduto() throws Exception {
        Long idProduto = 1L;

        mockMvc.perform(
                        delete(PRODUTOS_URL_PADRAO + "/" + idProduto)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    private ProdutoRequestDTO montarProdutoRequestDTO() {
        ProdutoRequestDTO produtoRequestDTO = new ProdutoRequestDTO();
        produtoRequestDTO.setNome("Porção de batatas");
        produtoRequestDTO.setDescricao("500g de batatas fritas");
        produtoRequestDTO.setIdCategoria(1L);
        produtoRequestDTO.setPreco(25.00);

        return produtoRequestDTO;
    }
}
