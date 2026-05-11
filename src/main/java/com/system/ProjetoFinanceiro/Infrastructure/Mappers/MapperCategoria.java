package com.system.ProjetoFinanceiro.Infrastructure.Mappers;

import com.system.ProjetoFinanceiro.Domain.Entity.Categoria;
import com.system.ProjetoFinanceiro.Infrastructure.dtos.CategoriaDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperCategoria {

    public Categoria toEntity (CategoriaDTO dto) {
        if (dto == null) return null;
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        return categoria;
    }

    public CategoriaDTO toDTO (Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
