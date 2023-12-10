package com.projeto.confeitart.demo.controller;

import com.projeto.confeitart.demo.model.Modulo;
import com.projeto.confeitart.demo.services.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> getModuloById(@PathVariable Long id) {
        Modulo modulo = moduloService.getModuloById(id);
        if (modulo != null) {
            return ResponseEntity.ok(modulo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Modulo>> listarModulos() {
        List<Modulo> modulos = moduloService.getAllModulos();
        return ResponseEntity.ok(modulos);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarModulo(@RequestBody Modulo modulo) {
        moduloService.saveModulo(modulo);
        return ResponseEntity.ok("Módulo adicionado com sucesso.");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerModulo(@PathVariable Long id) {
        Modulo modulo = moduloService.getModuloById(id);
        if (modulo != null) {
            moduloService.deleteModulo(id);
            return ResponseEntity.ok("Módulo removido com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
