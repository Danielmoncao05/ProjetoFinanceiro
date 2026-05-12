package com.system.ProjetoFinanceiro.Controller;

import com.system.ProjetoFinanceiro.Infrastructure.dtos.CategoriaDTO;
import com.system.ProjetoFinanceiro.application.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaCotroller {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public CategoriaDTO cadastrarCategoria (@RequestBody CategoriaDTO dto) {
        return service.cadastrarCategoria(dto);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listaDeCategoria () {
        return ResponseEntity.ok(service.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId (@PathVariable Long id) {
        return service.buscarCategoriaPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCategoria (@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        if (service.atualizarCategoria(id, dto)) {
            return ResponseEntity.ok("categoria atualizada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCategora (@PathVariable Long id) {
        if (service.deletarCategoria(id)){
            return ResponseEntity.ok("Categoria deletada");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}
