package br.com.fiap.techchallenge01.pedido.adapter.out.entity;

import br.com.fiap.techchallenge01.core.utils.entity.JpaBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class JpaPedidoEntity extends JpaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private String status;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "cdPagamento")
    private String codigoPagamento;

    @OneToMany(mappedBy="pedido")
    private List<JpaProdutoPedidoEntity> produtos = new ArrayList<>();
}