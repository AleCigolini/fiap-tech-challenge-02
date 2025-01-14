package br.com.fiap.techchallenge01.pedido.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Pedido {

    private String id;
    private String codigo;
    private String status;
    private BigDecimal preco;
    private String codigoPagamento;
    private String observacao;
    private List<ProdutoPedido> produtos;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAlteracao;
}