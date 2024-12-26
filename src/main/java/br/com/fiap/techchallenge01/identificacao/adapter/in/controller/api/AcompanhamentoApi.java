package br.com.fiap.techchallenge01.identificacao.adapter.in.controller.api;

import br.com.fiap.techchallenge01.identificacao.domain.dto.request.AcompanhamentoRequestDTO;
import br.com.fiap.techchallenge01.identificacao.domain.dto.response.AcompanhamentoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "API de acompanhamentos")
public interface AcompanhamentoApi {

    /**
     * Busca o acompanhamento a partir de seu ID.
     *
     * @param id Long do acompanhamento
     * @return {@link AcompanhamentoResponseDTO}
     */
    @Operation(summary = "Buscar acompanhamento com Id")
    ResponseEntity<AcompanhamentoResponseDTO> buscarAcompanhamento(Long id);

    /**
     * Cadastrar um novo acompanhamento.
     *
     * @param acompanhamentoRequestDto Dados do acompanhamento
     * @return {@link AcompanhamentoRequestDTO}
     */
    @Operation(summary = "Cadastro de acompanhamento")
    ResponseEntity<AcompanhamentoRequestDTO> cadastrarAcompanhamento(AcompanhamentoRequestDTO acompanhamentoRequestDto);

    /**
     * Listar todos os acompanhamentos.
     *
     * @return Lista de {@link AcompanhamentoResponseDTO}
     */
    @Operation(summary = "Listar todos os acompanhamentos")
    ResponseEntity<List<AcompanhamentoResponseDTO>> listarAcompanhamentos();
}