package br.com.fiap.techchallenge02.cliente.application.presenter;

import br.com.fiap.techchallenge02.cliente.common.domain.dto.response.ClienteResponseDto;
import br.com.fiap.techchallenge02.cliente.domain.Cliente;

public interface ClientePresenter {
    ClienteResponseDto toResponse(Cliente usuario);
}
