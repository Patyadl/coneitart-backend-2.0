package com.projeto.confeitart.demo.controller;

import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.model.Usuario;
import com.projeto.confeitart.demo.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = cursoService.getCursoById(id);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarCurso(@RequestBody Curso curso) {
        cursoService.adicionarCurso(curso);
        return ResponseEntity.ok("Curso adicionado com sucesso.");
    }

    @PostMapping("/matricular/{cursoId}")
    public ResponseEntity<String> matricularAlunoNoCurso(
            @PathVariable Long cursoId,
            @RequestBody Aluno aluno) {
        cursoService.matricula(cursoId, aluno);
        return ResponseEntity.ok("Aluno matriculado no curso com sucesso.");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerCurso(@PathVariable Long id) {
        Curso curso = cursoService.getCursoById(id);
        if (curso != null) {
            cursoService.removerCurso(curso);
            return ResponseEntity.ok("Curso removido com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

