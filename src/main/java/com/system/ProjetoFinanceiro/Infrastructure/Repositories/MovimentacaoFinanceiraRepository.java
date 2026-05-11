package com.system.ProjetoFinanceiro.Infrastructure.Repositories;

import com.system.ProjetoFinanceiro.Domain.Entity.MovimentacaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceira, Long> {
}
