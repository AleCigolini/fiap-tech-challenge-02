package br.com.fiap.techchallenge01.cliente.adapter.in.controller.api;

import br.com.fiap.techchallenge01.cliente.domain.ClienteRequestDto;
import br.com.fiap.techchallenge01.cliente.domain.ClienteResponseDto;
import br.com.fiap.techchallenge01.cliente.domain.validator.Cpf;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@Tag(name = "${tag.swagger.cliente.name}")
public interface ClienteApi {

    /**
     * Busca o cliente a partir de seu CPF.
     *
     * @param cpf String do cpf do cliente
     * @return {@link ResponseEntity<ClienteResponseDto>}
     */
    @Operation(summary = "Buscar cliente a partir de seu cpf",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Encontrado mais de um cliente para o mesmo cpf",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Cliente não encntrado",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    ResponseEntity<ClienteResponseDto> buscarClientePorCpf(@Valid @Cpf String cpf);

    /**
     * Cadastrar um novo cliente.
     *
     * @param clienteRequestDto objeto contendo os dados para cadastro do cliente, possuindo cpf ou e-mail obrigatóriamente e de maneira válida
     * @return {@link ResponseEntity<ClienteResponseDto>}
     */
    @Operation(summary = "Cadastrar cliente",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Erro no cadastro do cliente",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    ),
    })
    ResponseEntity<ClienteResponseDto> cadastrarCliente(@Valid ClienteRequestDto clienteRequestDto);

}
