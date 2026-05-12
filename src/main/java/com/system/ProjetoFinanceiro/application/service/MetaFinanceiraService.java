package com.system.ProjetoFinanceiro.application.service;

import com.system.ProjetoFinanceiro.Domain.Entity.MetaFinanceira;
import com.system.ProjetoFinanceiro.Infrastructure.Mappers.MapperMetaFinanceira;
import com.system.ProjetoFinanceiro.Infrastructure.Repositories.MetaFinanceiraRepository;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.MetaFinanceiraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetaFinanceiraService {

    @Autowired
    private MetaFinanceiraRepository repository;

    @Autowired
    private MapperMetaFinanceira mapperMetaFinanceira;

    public MetaFinanceiraDTO cadastrarMeta (MetaFinanceiraDTO dto) {
        MetaFinanceira metaFinanceira = mapperMetaFinanceira.toEntity(dto);
        repository.save(metaFinanceira);
        return mapperMetaFinanceira.toDTO(metaFinanceira);
    }

    public List<MetaFinanceiraDTO> listarMetasFinanceiras () {
        return repository.findAll().stream().map(mapperMetaFinanceira::toDTO).collect(Collectors.toList());
    }

    public Optional<MetaFinanceiraDTO> buscarMetaPorId (Long id) {
        return repository.findById(id).map(mapperMetaFinanceira::toDTO);
    }

    public boolean atualizarMetaFinanceira (Long id, MetaFinanceiraDTO dto) {
        return repository.findById(id).map(metaFinanceira -> {
            metaFinanceira.setTitulo(dto.titulo());
            metaFinanceira.setValorMeta(dto.valorMeta());
            metaFinanceira.setValorAtual(dto.valorAtual());
            metaFinanceira.setDataLimite(dto.dataLimite());
            metaFinanceira.setStatus(dto.status());
            metaFinanceira.setUser(dto.user());
            repository.save(metaFinanceira);
            return true;

        }).orElse(false);
    }

    public boolean deletarMetaFinanceira (Long id) {
        return repository.findById(id).map(metaFinanceira -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }
}
