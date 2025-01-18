package br.com.fiap.techchallenge01.produto.adapter.out.entity;

import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaPedidoEntity;
import br.com.fiap.techchallenge01.pedido.adapter.out.entity.JpaProdutoPedidoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class JpaProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private JpaCategoriaProdutoEntity categoria;

    @Column(name = "preco")
    private Double preco;
}