package com.system.ProjetoFinanceiro.Domain.Entity;

import com.system.ProjetoFinanceiro.Domain.Enum.TipoTransacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao", nullable = false)
    private Long idMovimentacao;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor",nullable = false)
    private Double valor;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "tipo_transacao", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @OneToOne(mappedBy = "movimentacaoFinanceira", optional = true)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;
}
