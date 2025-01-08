package br.com.fiap.techchallenge01.cliente.adapter.in.controller.api;

import br.com.fiap.techchallenge01.cliente.domain.ClienteRequestDto;
import br.com.fiap.techchallenge01.cliente.domain.ClienteResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "${tag.swagger.cliente.name}")
public interface ClienteApi {

    /**
     * Busca o usuário a partir de seu CPF.
     *
     * @param cpf String do cpf do usuário
     * @return {@link ResponseEntity< ClienteResponseDto >}
     */
    @Operation(summary = "Buscar um usuário a partir de seu cpf")
    ResponseEntity<ClienteResponseDto> buscarClientePorCpf(String cpf);

    /**
     * Cadastrar um novo usuário.
     *
     * @param clienteRequestDto objeto contendo os dados para cadastro do usuário
     * @return {@link ResponseEntity< ClienteResponseDto >}
     */
    @Operation(summary = "Cadastrar usuário")
    ResponseEntity<ClienteResponseDto> cadastrarCliente(ClienteRequestDto clienteRequestDto);

}
