package br.com.fiap.techchallenge01.pedido.domain;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class ProdutoPedido {

    private String id;
    private String observacao;
    private Produto produto;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAlteracao;
    private Boolean ativo;
}