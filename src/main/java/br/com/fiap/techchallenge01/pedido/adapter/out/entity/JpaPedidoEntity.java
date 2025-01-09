package br.com.fiap.techchallenge01.pedido.adapter.out.entity;

import br.com.fiap.techchallenge01.produto.adapter.out.entity.JpaProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class JpaPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private String status;

    @Column(name = "preco")
    private Double preco;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "pedido_produto",
            joinColumns = { @JoinColumn(name = "id_pedido") },
            inverseJoinColumns = { @JoinColumn(name = "id_produto") }
    )
    private List<JpaProdutoEntity> produtos = new ArrayList<>();
}