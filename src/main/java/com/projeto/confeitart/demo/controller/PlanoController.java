package com.projeto.confeitart.demo.controller;

import com.projeto.confeitart.demo.model.Plano;
import com.projeto.confeitart.demo.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    public ResponseEntity<Plano> getPlanoById(@PathVariable Long id) {
        Plano plano = planoService.getPlanoById(id);
        if (plano != null) {
            return ResponseEntity.ok(plano);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarPlano(@RequestBody Plano plano) {
        planoService.adicionarPlano(plano);
        return ResponseEntity.ok("Plano adicionado com sucesso.");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Plano>> listarPlanos() {
        List<Plano> planos = planoService.listarPlanos();
        return ResponseEntity.ok(planos);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerPlano(@PathVariable Long id) {
        Plano plano = planoService.getPlanoById(id);
        if (plano != null) {
            planoService.deletarPlano(plano.getId());
            return ResponseEntity.ok("Plano removido com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
