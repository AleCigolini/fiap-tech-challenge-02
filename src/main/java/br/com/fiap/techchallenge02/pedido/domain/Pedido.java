package br.com.fiap.techchallenge02.pedido.domain;

import br.com.fiap.techchallenge02.core.utils.domain.DominioBase;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Pedido extends DominioBase {

    private String id;
    private String codigo;
    private String status;
    private BigDecimal preco;
    private String codigoPagamento;
    private String observacao;
//    private Cliente cliente;
    private List<ProdutoPedido> produtos;
}