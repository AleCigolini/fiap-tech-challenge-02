package br.com.fiap.techchallenge02.pedido.common.domain.entity;

import br.com.fiap.techchallenge02.core.utils.entity.JpaBaseEntity;
import br.com.fiap.techchallenge02.produto.common.entity.JpaProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto_pedido")
public class JpaProdutoPedidoEntity extends JpaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "quantidade")
    private Long quantidade;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name="id_pedido", nullable=false)
    private JpaPedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name="id_produto", nullable=false)
    private JpaProdutoEntity produto;
}