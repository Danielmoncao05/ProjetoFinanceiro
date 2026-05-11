package com.system.ProjetoFinanceiro.Infrastructure.Mappers;

import com.system.ProjetoFinanceiro.Domain.Entity.User;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperUser {

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
        return new UserDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getSenha(),
                user.getDataNascimento()
        );
    }
}
