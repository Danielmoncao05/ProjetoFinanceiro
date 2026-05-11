package com.system.ProjetoFinanceiro.application.service;

import com.system.ProjetoFinanceiro.Domain.Entity.User;
import com.system.ProjetoFinanceiro.Infrastructure.Mappers.MapperUser;
import com.system.ProjetoFinanceiro.Infrastructure.Repositories.UserRepository;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MapperUser mapperUser;

    public UserDTO criarUsuario (UserDTO dto) {
        User user = mapperUser.toEntity(dto);
        repository.save(user);

        return mapperUser.toDTO(user);
    }

    public List<UserDTO> listarUsuarios () {
        return repository.findAll().stream().map(mapperUser::toDTO).collect(Collectors.toList());
    }

    public Optional<UserDTO> procurarPorId (Long id){
        return repository.findById(id).map(mapperUser::toDTO);
    }

    public boolean atualizarUsuario (Long id, UserDTO dto){
        return repository.findById(id).map(user -> {
            user.setNome(dto.nome());
            user.setEmail(dto.email());
            user.setSenha(dto.senha());
            user.setDataNascimento(dto.dataNascimento());

            repository.save(user);
            return true;

        }).orElse(false);
    }

    public boolean deletarUsuario (Long id) {
        return repository.findById(id).map(user -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }
}
