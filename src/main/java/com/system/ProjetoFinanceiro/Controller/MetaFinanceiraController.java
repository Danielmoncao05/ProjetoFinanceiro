package com.system.ProjetoFinanceiro.Controller;

import com.system.ProjetoFinanceiro.Infrastructure.dtos.MetaFinanceiraDTO;
import com.system.ProjetoFinanceiro.application.service.MetaFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
import java.util.List;

@Controller
@RequestMapping("/metaFinanceira")
public class MetaFinanceiraController {

    @Autowired
    private MetaFinanceiraService service;


    @PostMapping
    public MetaFinanceiraDTO registrarMeta (@RequestBody MetaFinanceiraDTO dto) {
        return service.cadastrarMeta(dto);
    }

    @GetMapping
    public ResponseEntity<List<MetaFinanceiraDTO>> listarMetas () {
        return ResponseEntity.ok(service.listarMetasFinanceiras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaFinanceiraDTO> buscarMetaPorId (@PathVariable Long id) {
        return service.buscarMetaPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarMeta (@PathVariable Long id, @RequestBody MetaFinanceiraDTO dto) {
        if (service.atualizarMetaFinanceira(id, dto)){
            return ResponseEntity.ok("Meta atualizada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMeta (@PathVariable Long id) {
        if (service.deletarMetaFinanceira(id)) {
            return ResponseEntity.ok("Meta deletada");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}
