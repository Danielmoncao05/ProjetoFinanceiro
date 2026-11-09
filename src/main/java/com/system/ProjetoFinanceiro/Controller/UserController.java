package com.system.ProjetoFinanceiro.Controller;

import com.system.ProjetoFinanceiro.Infrastructure.dtos.UserDTO;
import com.system.ProjetoFinanceiro.application.service.UserService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
private UserService service;

    @PostMapping
    public UserDTO novoUsuario (@RequestBody UserDTO dto) {
        return service.criarUsuario(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listarUsuarios () {
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> buscarPorId (@PathVariable Long id) {
        return service.procurarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario (@PathVariable Long id, @RequestBody UserDTO dto) {
        if (service.atualizarUsuario(id, dto)) {
            return ResponseEntity.ok("usuario atualizado");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<String> deletarUsuario (@PathVariable Long id) {
            if (service.deletarUsuario(id)) {
                return   ResponseEntity.ok("Usuario deletado");
            } else {
                return ResponseEntity.notFound().build();
            }
        }
}
