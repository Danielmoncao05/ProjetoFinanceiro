package com.system.ProjetoFinanceiro.Domain.Entity;

import com.system.ProjetoFinanceiro.Domain.Enum.TipoTransacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long idMovimentacao;

    private String descricao;
    private Double valor;
    private LocalDate data;
    private TipoTransacao tipo;
    private Boolean status;
    private Categoria categoria;
    private User user;
}
