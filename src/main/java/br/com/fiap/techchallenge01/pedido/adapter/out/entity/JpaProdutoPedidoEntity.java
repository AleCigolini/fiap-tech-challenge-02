package br.com.fiap.techchallenge01.pedido.adapter.out.entity;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto_pedido")
public class JpaProdutoPedidoEntity {

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

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CreationTimestamp
    private OffsetDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime dataAtualizacao;
}