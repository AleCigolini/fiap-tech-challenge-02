package br.com.fiap.techchallenge01.pedido.domain.dto.request;

import br.com.fiap.techchallenge01.produto.domain.Produto;
import br.com.fiap.techchallenge01.produto.domain.dto.request.ProdutoRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {

    @NotEmpty
    private List<PedidoListaProdutoRequestDTO> produtos;

//    TODO: FAZER PAGAMENTO
//    @NotNull
//    private Pagamento pagamento;
}