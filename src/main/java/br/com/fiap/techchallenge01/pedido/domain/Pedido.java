package br.com.fiap.techchallenge01.pedido.domain;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Pedido {

    private String id;
    private String codigo;
    private String status; // TODO: CONVERTER EM ENUM? "ABERTO", APROVADO, "EM_ANDAMENTO", "ENTREGUE", "FINALIZADO", "CANCELADO"
    private Double preco;
    private List<Produto> produtos;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAlteracao;
    private Boolean eAtivo;
}