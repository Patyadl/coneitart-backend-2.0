package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.repositories.AlunoRepository;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {


    private final CursoRepository cursoRepository;


    @Autowired
    public CursoService(CursoRepository cursoRepository, AlunoRepository alunoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void matricula(Long cursoId, Aluno aluno) {
        Optional<Curso> cursoOptional = cursoRepository.findByIdWithAlunos(cursoId);

        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            List<Aluno> alunos = curso.getAlunos();

            if (alunos == null) {
                alunos = new ArrayList<>();
            }

            alunos.add(aluno);
            curso.setAlunos(alunos);

            cursoRepository.save(curso);
        } else {
            throw new EntityNotFoundException("Curso com ID " + cursoId + " não encontrado.");
        }
    }



    public void adicionarCurso(Curso curso){
        cursoRepository.save(curso);
    }
 //public  void removerCurso(Curso curso){
       // cursoRepository.delete(curso);}

}
