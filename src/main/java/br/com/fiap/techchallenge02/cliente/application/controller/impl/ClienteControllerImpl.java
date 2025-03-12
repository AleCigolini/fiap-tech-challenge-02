package br.com.fiap.techchallenge02.cliente.application.controller.impl;

import br.com.fiap.techchallenge02.cliente.application.controller.ClienteController;
import br.com.fiap.techchallenge02.cliente.application.mapper.RequestClienteMapper;
import br.com.fiap.techchallenge02.cliente.application.presenter.ClientePresenter;
import br.com.fiap.techchallenge02.cliente.application.usecase.ConsultarClienteUseCase;
import br.com.fiap.techchallenge02.cliente.application.usecase.SalvarClienteUseCase;
import br.com.fiap.techchallenge02.cliente.common.domain.dto.request.ClienteRequestDto;
import br.com.fiap.techchallenge02.cliente.common.domain.dto.response.ClienteResponseDto;
import br.com.fiap.techchallenge02.core.utils.domain.Cpf;
import br.com.fiap.techchallenge02.core.utils.domain.Email;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class ClienteControllerImpl implements ClienteController {
    private final SalvarClienteUseCase salvarClienteUseCase;
    private final ConsultarClienteUseCase consultarClienteUseCase;

    private final RequestClienteMapper requestClienteMapper;
    private final ClientePresenter clientePresenter;

    @Override
    public ClienteResponseDto buscarClientePorCpf(String cpf) {
        return clientePresenter.toResponse(consultarClienteUseCase.buscarClientePorCpf(new Cpf(cpf)));
    }

    @Override
    public ClienteResponseDto buscarClientePorEmail(String email) {
        return clientePresenter.toResponse(consultarClienteUseCase.buscarClientePorEmail(new Email(email)));
    }

    @Override
    public ClienteResponseDto buscarClientePorId(UUID id) {
        return clientePresenter.toResponse(consultarClienteUseCase.buscarClientePorId(id));
    }

    @Override
    public ClienteResponseDto cadastrarCliente(ClienteRequestDto clienteRequestDto) {
        return clientePresenter.toResponse(salvarClienteUseCase.salvarCliente(requestClienteMapper.requestDtoToDomain(clienteRequestDto)));
    }
}
