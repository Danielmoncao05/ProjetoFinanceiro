package com.system.ProjetoFinanceiro.application.service;

import com.system.ProjetoFinanceiro.Domain.Entity.Categoria;
import com.system.ProjetoFinanceiro.Infrastructure.Mappers.MapperCategoria;
import com.system.ProjetoFinanceiro.Infrastructure.Repositories.CategoriaRepository;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.CategoriaDTO;
import org.hibernate.resource.beans.container.spi.BeanLifecycleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private MapperCategoria mapperCategoria;

    public CategoriaDTO cadastrarCategoria (CategoriaDTO dto) {
        Categoria categoria = mapperCategoria.toEntity(dto);
        repository.save(categoria);

        return mapperCategoria.toDTO(categoria);
    }

    public List<CategoriaDTO> listarCategorias () {
        return repository.findAll().stream().map(mapperCategoria::toDTO).collect(Collectors.toList());
    }

    public Optional<CategoriaDTO> buscarCategoriaPorId (Long id) {
        return repository.findById(id).map(mapperCategoria::toDTO);
    }

    public boolean atualizarCategoria (Long id, CategoriaDTO dto) {
        return repository.findById(id).map(categoria ->  {
            categoria.setNome(dto.nome());
            categoria.setDescricao(dto.descricao());

            repository.save(categoria);
            return true;

        }).orElse(false);
    }

    public boolean deletarCategoria (Long id) {
        return repository.findById(id).map(categoria -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }
}
