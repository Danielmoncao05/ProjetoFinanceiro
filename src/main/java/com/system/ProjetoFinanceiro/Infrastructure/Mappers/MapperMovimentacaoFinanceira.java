package com.system.ProjetoFinanceiro.Infrastructure.Mappers;

import com.system.ProjetoFinanceiro.Domain.Entity.MovimentacaoFinanceira;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.MovimentacaoFinanceiraDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperMovimentacaoFinanceira {

    public MovimentacaoFinanceira toEntity (MovimentacaoFinanceiraDTO dto) {
        if (dto == null) return null;
        MovimentacaoFinanceira movimentacaoFinanceira = new MovimentacaoFinanceira();
        movimentacaoFinanceira.setDescricao(dto.descricao());
        movimentacaoFinanceira.setValor(dto.valor());
        movimentacaoFinanceira.setData(dto.data());
        movimentacaoFinanceira.setTipo(dto.tipo());
        movimentacaoFinanceira.setStatus(dto.status());
        movimentacaoFinanceira.getCategoria().setId(dto.idCategoria());
        movimentacaoFinanceira.getUser().setId(dto.idUser());

        return movimentacaoFinanceira;
    }

    public MovimentacaoFinanceiraDTO toDTO (MovimentacaoFinanceira movimentacaoFinanceira) {
        return new MovimentacaoFinanceiraDTO(
                movimentacaoFinanceira.getIdMovimentacao(),
                movimentacaoFinanceira.getDescricao(),
                movimentacaoFinanceira.getValor(),
                movimentacaoFinanceira.getData(),
                movimentacaoFinanceira.getTipo(),
                movimentacaoFinanceira.getStatus(),
                movimentacaoFinanceira.getCategoria().getId(),
                movimentacaoFinanceira.getUser().getId()
        );
    }
}
