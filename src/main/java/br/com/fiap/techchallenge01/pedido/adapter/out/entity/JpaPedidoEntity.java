package br.com.fiap.techchallenge01.pedido.adapter.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class JpaPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private String status;

//    @Column(name = "produtos")
//    // TODO: CORRIGIR FORMATO PARA SALVAR PRODUTOS NO BD
//    private List<JpaProdutoEntity> produtos;

    @Column(name = "valor")
    private Double valor;
}