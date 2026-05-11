package com.system.ProjetoFinanceiro.application.service;

import com.system.ProjetoFinanceiro.Infrastructure.Mappers.MapperCategoria;
import com.system.ProjetoFinanceiro.Infrastructure.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private MapperCategoria mapperCategoria;
}
