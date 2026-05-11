package com.system.ProjetoFinanceiro.Infrastructure.dtos;

import com.system.ProjetoFinanceiro.Domain.Entity.Categoria;
import com.system.ProjetoFinanceiro.Domain.Entity.User;
import com.system.ProjetoFinanceiro.Domain.Enum.TipoTransacao;

import java.time.LocalDate;

public record MovimentacaoFinanceiraDTO(
        Long idMovimentacao,
        String descricao,
        Double valor,
        LocalDate data,
        TipoTransacao tipo,
        Boolean status,
        Categoria categoria,
        User user
) {
}
