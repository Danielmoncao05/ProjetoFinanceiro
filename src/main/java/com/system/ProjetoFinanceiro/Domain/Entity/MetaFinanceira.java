package com.system.ProjetoFinanceiro.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta", nullable = false)
    private Long idMeta;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "valor_meta", nullable = false)
    private Double valorMeta;

    @Column(name = "valor_atual", nullable = false)
    private Double valorAtual;

    @Column(name = "data_limite", nullable = false)
    private LocalDate dataLimite;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
