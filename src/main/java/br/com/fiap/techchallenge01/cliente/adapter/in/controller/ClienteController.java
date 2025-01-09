package br.com.fiap.techchallenge01.cliente.adapter.in.controller;

import br.com.fiap.techchallenge01.cliente.adapter.in.controller.api.ClienteApi;
import br.com.fiap.techchallenge01.cliente.application.service.ClienteService;
import br.com.fiap.techchallenge01.cliente.domain.Cliente;
import br.com.fiap.techchallenge01.cliente.domain.ClienteRequestDto;
import br.com.fiap.techchallenge01.cliente.domain.ClienteResponseDto;
import br.com.fiap.techchallenge01.cliente.utils.mapper.ClienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController implements ClienteApi {
    private ClienteMapper clienteMapper;
    private ClienteService clienteService;

    @Override
    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteResponseDto> buscarClientePorCpf(@RequestParam String cpf) {
        final ClienteResponseDto clienteResponseDto = clienteMapper.toResponse(clienteService.buscarClientePorCpf(cpf));
        return ResponseEntity.ok(clienteResponseDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrarCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        final Cliente cliente = clienteService.salvarCliente(clienteMapper.requestDtoToDomain(clienteRequestDto));
        return ResponseEntity.ok(clienteMapper.toResponse(cliente));
    }

}
