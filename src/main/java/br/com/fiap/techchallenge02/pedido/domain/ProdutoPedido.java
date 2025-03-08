package br.com.fiap.techchallenge02.pedido.domain;

import br.com.fiap.techchallenge02.core.utils.domain.DominioBase;
import br.com.fiap.techchallenge02.produto.domain.Produto;
import lombok.Data;

@Data
public class ProdutoPedido extends DominioBase {

    private String id;
    private Long quantidade;
    private String observacao;
    private Produto produto;
}