package br.com.fiap.techchallenge01.cliente.domain.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ClienteResponseDto {
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;
}
