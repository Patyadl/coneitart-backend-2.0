package com.projeto.confeitart.demo.controller;


import com.projeto.confeitart.demo.model.Categoria;
import com.projeto.confeitart.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarCategoria(@RequestBody Categoria categoria) {
        categoriaService.adicionarCategoria(categoria);
        return ResponseEntity.ok("Categoria adicionada com sucesso.");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        if (categoria != null) {
            categoriaService.deletarCategoria(categoria.getId());
            return ResponseEntity.ok("Categoria removida com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
