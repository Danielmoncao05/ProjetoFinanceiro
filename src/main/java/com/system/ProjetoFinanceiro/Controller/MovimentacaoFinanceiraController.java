package com.system.ProjetoFinanceiro.Controller;

import com.system.ProjetoFinanceiro.Infrastructure.dtos.MovimentacaoFinanceiraDTO;
import com.system.ProjetoFinanceiro.application.service.MovimentacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movimentacaoFinanceira")
public class MovimentacaoFinanceiraController {

    @Autowired
    private MovimentacaoFinanceiraService service;

    @PostMapping
    public MovimentacaoFinanceiraDTO cadastrarMovimentacao (@RequestBody MovimentacaoFinanceiraDTO dto) {
        return service.cadastrarMovimentacao(dto);
    }

    @GetMapping
    public ResponseEntity<List<MovimentacaoFinanceiraDTO>> listarMovimentacoes () {
        return ResponseEntity.ok(service.listarMovimentacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoFinanceiraDTO> buscarMovimentoPorId (@PathVariable Long id) {
        return service.buscarMovimentacaoPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
