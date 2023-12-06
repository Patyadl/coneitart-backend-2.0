package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.repositories.AlunoRepository;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired

    private final CursoRepository cursoRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository, AlunoRepository alunoRepository) {
        this.cursoRepository = cursoRepository;
        this.alunoRepository = alunoRepository;
    }

    @Autowired
    private Aluno aluno;


    public void matricula(Long cursoId, Long alunoid) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID: " + cursoId));

        Aluno aluno= alunoRepository.findById(alunoid)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + alunoid));



        curso.getAlunos().add(aluno);
        //aluno.getCursos().add(curso);
        alunoRepository.save(aluno);
        cursoRepository.save(curso);
    }


    public Curso adicionarCurso(Curso curso){
     return cursoRepository.save(curso);
    }


}
