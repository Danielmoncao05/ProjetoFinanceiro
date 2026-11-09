package com.system.ProjetoFinanceiro.Infrastructure.Mappers;

import com.system.ProjetoFinanceiro.Domain.Entity.User;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MapperUser {

    @Autowired
    private MapperMovimentacaoFinanceira mapperMovimentacaoFinanceira;

    public User toEntity (UserDTO dto) {
        if (dto == null) return  null;
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());
        user.setDataNascimento(dto.dataNascimento());

        return user;
    }

    public UserDTO toDTO (User user) {

        if(user.getMovimentacaoFinanceira() == null) {
            return null;
        }
        return new UserDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getSenha(),
                user.getDataNascimento(),
//                user.getMovimentacaoFinanceira()
                user.getMovimentacaoFinanceira().stream().map(mapperMovimentacaoFinanceira::toDTO).collect(Collectors.toList())
        );
    }
}
