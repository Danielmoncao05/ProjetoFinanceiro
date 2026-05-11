package com.system.ProjetoFinanceiro.Infrastructure.dtos;

import com.system.ProjetoFinanceiro.Domain.Entity.User;

import java.time.LocalDate;

public record MetaFinanceiraDTO(
        Long idMeta,
        String titulo,
        Double valorMeta,
        Double valorAtual,
        LocalDate dataLimite,
        Boolean status,
        User user
) {
}
