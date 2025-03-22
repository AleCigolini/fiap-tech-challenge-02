package br.com.fiap.techchallenge02.cliente.application.controller.impl;

import br.com.fiap.techchallenge02.cliente.application.controller.ClienteController;
import br.com.fiap.techchallenge02.cliente.application.gateway.ClienteGateway;
import br.com.fiap.techchallenge02.cliente.application.gateway.impl.ClienteGatewayImpl;
import br.com.fiap.techchallenge02.cliente.application.mapper.DatabaseClienteMapper;
import br.com.fiap.techchallenge02.cliente.application.mapper.RequestClienteMapper;
import br.com.fiap.techchallenge02.cliente.application.presenter.ClientePresenter;
import br.com.fiap.techchallenge02.cliente.application.usecase.ConsultarClienteUseCase;
import br.com.fiap.techchallenge02.cliente.application.usecase.SalvarClienteUseCase;
import br.com.fiap.techchallenge02.cliente.application.usecase.impl.ConsultarClienteUseCaseImpl;
import br.com.fiap.techchallenge02.cliente.application.usecase.impl.SalvarClienteUseCaseImpl;
import br.com.fiap.techchallenge02.cliente.common.domain.dto.request.ClienteRequestDto;
import br.com.fiap.techchallenge02.cliente.common.domain.dto.response.ClienteResponseDto;
import br.com.fiap.techchallenge02.cliente.common.interfaces.ClienteDatabase;
import br.com.fiap.techchallenge02.core.utils.domain.Cpf;
import br.com.fiap.techchallenge02.core.utils.domain.Email;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ClienteControllerImpl implements ClienteController {
    private final SalvarClienteUseCase salvarClienteUseCase;
    private final ConsultarClienteUseCase consultarClienteUseCase;

    private final RequestClienteMapper requestClienteMapper;
    private final ClientePresenter clientePresenter;

    public ClienteControllerImpl(ClienteDatabase clienteDatabase, DatabaseClienteMapper mapper, RequestClienteMapper requestClienteMapper, ClientePresenter clientePresenter) {
        this.requestClienteMapper = requestClienteMapper;
        this.clientePresenter = clientePresenter;
        final ClienteGateway clienteGateway = new ClienteGatewayImpl(clienteDatabase, mapper);
        this.salvarClienteUseCase = new SalvarClienteUseCaseImpl(clienteGateway);
        this.consultarClienteUseCase = new ConsultarClienteUseCaseImpl(clienteGateway);
    }

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
