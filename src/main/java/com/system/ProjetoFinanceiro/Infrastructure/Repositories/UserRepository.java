package com.system.ProjetoFinanceiro.Infrastructure.Repositories;

import com.system.ProjetoFinanceiro.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//  < entidade , valor do id >
public interface UserRepository extends JpaRepository <User, Long> {

}
