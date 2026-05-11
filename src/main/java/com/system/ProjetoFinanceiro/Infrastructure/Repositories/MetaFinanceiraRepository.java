package com.system.ProjetoFinanceiro.Infrastructure.Repositories;

import com.system.ProjetoFinanceiro.Domain.Entity.MetaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaFinanceiraRepository extends JpaRepository<MetaFinanceira, Long> {
}
