package com.system.ProjetoFinanceiro.Infrastructure.dtos;

import com.system.ProjetoFinanceiro.Domain.Entity.MovimentacaoFinanceira;

import java.time.LocalDate;
import java.util.List;

public record UserDTO(
        Long id,
        String nome,
        String email,
        String senha,
        LocalDate dataNascimento,
        List<MovimentacaoFinanceira> movimentacoes
) {
}
