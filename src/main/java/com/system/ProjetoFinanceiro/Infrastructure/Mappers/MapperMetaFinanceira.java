package com.system.ProjetoFinanceiro.Infrastructure.Mappers;

import com.system.ProjetoFinanceiro.Domain.Entity.MetaFinanceira;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.MetaFinanceiraDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperMetaFinanceira {

    public MetaFinanceira toEntity (MetaFinanceiraDTO dto) {
        if (dto == null) return null;
        MetaFinanceira metaFinanceira = new MetaFinanceira();
        metaFinanceira.setTitulo(dto.titulo());
        metaFinanceira.setValorMeta(dto.valorMeta());
        metaFinanceira.setValorAtual(dto.valorAtual());
        metaFinanceira.setDataLimite(dto.dataLimite());
        metaFinanceira.setStatus(dto.status());
        metaFinanceira.setUser(dto.user());

        return metaFinanceira;
    }

    public MetaFinanceiraDTO toDTO (MetaFinanceira metaFinanceira) {
        return new MetaFinanceiraDTO(
                metaFinanceira.getIdMeta(),
                metaFinanceira.getTitulo(),
                metaFinanceira.getValorMeta(),
                metaFinanceira.getValorAtual(),
                metaFinanceira.getDataLimite(),
                metaFinanceira.getStatus(),
                metaFinanceira.getUser()
        );
    }
}
