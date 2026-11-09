package com.system.ProjetoFinanceiro.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario_gestao")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "Senha", nullable = false)
    private String senha;

    @Column(name = "Data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "movimentacoes", nullable = true)
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<MovimentacaoFinanceira> movimentacaoFinanceira;

}
