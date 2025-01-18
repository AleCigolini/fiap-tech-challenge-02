package br.com.fiap.techchallenge01.cliente.adapter.in.controller;

import br.com.fiap.techchallenge01.cliente.adapter.in.controller.api.ClienteApi;
import br.com.fiap.techchallenge01.cliente.application.usecase.ClienteUseCase;
import br.com.fiap.techchallenge01.cliente.config.mapper.ClienteMapper;
import br.com.fiap.techchallenge01.cliente.domain.dto.request.ClienteRequestDto;
import br.com.fiap.techchallenge01.cliente.domain.dto.response.ClienteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController implements ClienteApi {
    private final ClienteMapper clienteMapper;
    private final ClienteUseCase clienteUseCase;

    @Override
    @GetMapping("/cpf")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto buscarClientePorCpf(@RequestParam String cpf) {
        return clienteMapper.toResponse(clienteUseCase.buscarClientePorCpf(cpf));
    }

    @Override
    @GetMapping("/email")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto buscarClientePorEmail(@RequestParam String email) {
        return clienteMapper.toResponse(clienteUseCase.buscarClientePorEmail(email));
    }

    @Override
    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto buscarClientePorId(@RequestParam UUID id) {
        return  clienteMapper.toResponse(clienteUseCase.buscarClientePorId(id));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto cadastrarCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        return clienteMapper.toResponse(clienteUseCase.salvarCliente(clienteMapper.requestDtoToDomain(clienteRequestDto)));
    }

}
