package br.com.fiap.techchallenge01.produto.adapter.in.controller;

import br.com.fiap.techchallenge01.produto.domain.dto.response.ProdutoResponseDTO;
import br.com.fiap.techchallenge01.utils.JsonHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.StringTemplate.STR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTest {

    private static final String PRODUTOS_URL_PADRAO = "/produtos";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveBuscarTodosProdutos() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get(PRODUTOS_URL_PADRAO))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        ProdutoResponseDTO[] produtos = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO[].class);

        assertThat(produtos).isNotNull();
        assertThat(produtos.length).isEqualTo(3);
    }

    @Test
    void deveBuscarProdutoPorId() throws Exception {
        long idProduto = 1L;

        MockHttpServletResponse response = mockMvc.perform(get(STR."\{PRODUTOS_URL_PADRAO}/\{idProduto}"))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        ProdutoResponseDTO produto = JsonHelper.toObject(response.getContentAsByteArray(), ProdutoResponseDTO.class);

        assertThat(produto).isNotNull();
        assertThat(produto.getId()).isEqualTo(idProduto);
        assertThat(produto.getNome()).isEqualTo("Hamburguer");
        assertThat(produto.getDescricao()).isEqualTo("Pão, queijo, alface, tomate, carne.");
    }
}
