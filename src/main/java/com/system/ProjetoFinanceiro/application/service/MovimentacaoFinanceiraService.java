package com.system.ProjetoFinanceiro.application.service;


import com.system.ProjetoFinanceiro.Domain.Entity.MovimentacaoFinanceira;
import com.system.ProjetoFinanceiro.Infrastructure.Mappers.MapperMovimentacaoFinanceira;
import com.system.ProjetoFinanceiro.Infrastructure.Repositories.MovimentacaoFinanceiraRepository;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.MovimentacaoFinanceiraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimentacaoFinanceiraService {

    @Autowired
    private MovimentacaoFinanceiraRepository repository;

    @Autowired
    private MapperMovimentacaoFinanceira mapperMovimentacaoFinanceira;

    public MovimentacaoFinanceiraDTO cadastrarMovimentacao (MovimentacaoFinanceiraDTO dto) {
        MovimentacaoFinanceira movimentacaoFinanceira = mapperMovimentacaoFinanceira.toEntity(dto);
        repository.save(movimentacaoFinanceira);

        return mapperMovimentacaoFinanceira.toDTO(movimentacaoFinanceira);
    }

    public List<MovimentacaoFinanceiraDTO> listarMovimentacoes () {
        return repository.findAll().stream().map(mapperMovimentacaoFinanceira::toDTO).collect(Collectors.toList());
    }

    public Optional<MovimentacaoFinanceiraDTO> buscarMovimentacaoPorId (Long id) {
        return repository.findById(id).map(mapperMovimentacaoFinanceira::toDTO);
    }

    public boolean atualizarMovimentacao (Long id, MovimentacaoFinanceiraDTO dto) {
        return repository.findById(id).map(movimentacaoFinanceira ->  {
            movimentacaoFinanceira.setDescricao(dto.descricao());
            movimentacaoFinanceira.setValor(dto.valor());
            movimentacaoFinanceira.setData(dto.data());
            movimentacaoFinanceira.setTipo(dto.tipo());
            movimentacaoFinanceira.setStatus(dto.status());
            movimentacaoFinanceira.setCategoria(dto.categoria());;
            movimentacaoFinanceira.getUser().setId(dto.idUser());

            repository.save(movimentacaoFinanceira);
            return true;

        }).orElse(false);
    }

    public boolean deletarMovimentacao (Long id) {
        return repository.findById(id).map(movimentacaoFinanceira ->  {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }
}
