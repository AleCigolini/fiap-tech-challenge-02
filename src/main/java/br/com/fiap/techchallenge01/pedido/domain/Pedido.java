package br.com.fiap.techchallenge01.pedido.domain;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Pedido {

    private Long id;
    private String codigoPedido;
    private String status; // TODO: CONVERTER EM ENUM? "ABERTO", APROVADO, "EM_ANDAMENTO", "ENTREGUE", "FINALIZADO", "CANCELADO"
    private Double valorTotal;
    private List<Produto> itensProduto;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAlteracao;
    private Boolean eAtivo;
}