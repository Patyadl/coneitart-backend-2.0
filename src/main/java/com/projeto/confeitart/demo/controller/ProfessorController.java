package com.projeto.confeitart.demo.controller;

import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.model.Professor;
import com.projeto.confeitart.demo.services.CursoService;
import com.projeto.confeitart.demo.services.ProfessorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> alunos = professorService.listarProfessores();
        return ResponseEntity.ok(alunos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Professor professor = professorService.getProfessorById(id);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PostMapping("/inserir/{cursoId}")
    public ResponseEntity<String> inserirProfessorNoCurso(
            @PathVariable Long cursoId,
            @RequestBody Professor professor) {

        Curso curso = cursoService.getCursoById(cursoId);

        if (curso != null) {
            professorService.salvarProfessor(professor, curso);
            return ResponseEntity.ok("Professor inserido no curso com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    @PostMapping("/inserir/{cursoId}")
    public ResponseEntity<String> inserirProfessorNoCurso(
            @PathVariable Long cursoId,
            @RequestBody Professor professor) {

        Curso curso = cursoService.getCursoById(cursoId);

        if (curso != null) {
            professorService.salvarProfessor(professor, curso);
            return ResponseEntity.ok("Professor inserido no curso com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProfessor(@PathVariable Long id) {
        professorService.deletarprofessor(id);
        return ResponseEntity.ok("Professor excluído com sucesso.");
    }

}
