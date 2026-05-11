package com.system.ProjetoFinanceiro.Infrastructure.dtos;

import java.time.LocalDate;

public record UserDTO(
        Long id,
        String nome,
        String email,
        String senha,
        LocalDate dataNascimento
) {
}
