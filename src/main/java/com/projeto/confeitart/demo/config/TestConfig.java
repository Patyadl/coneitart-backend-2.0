package com.projeto.confeitart.demo.config;



import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.model.Professor;
import com.projeto.confeitart.demo.repositories.AlunoRepository;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import com.projeto.confeitart.demo.repositories.ProfessorRepository;
import com.projeto.confeitart.demo.services.AlunoService;
import com.projeto.confeitart.demo.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;


@Configuration //especifica que é uma classe de configuração
public class TestConfig implements CommandLineRunner {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoService alunoService;

    @Autowired
    CursoService cursoService;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {

        //Professor p1 = new Professor(2L, "Iago Rodrigues", "iago@gmail.com", 2345, "Doces");
        Professor p1 = new Professor();
        p1.setNome("Fernanda Fortunato");
        p1.setEmail("fernanda@gmail.com");
        p1.setSenha(2785);
        p1.setEspecializacao("confeitaria clássica");

        professorRepository.save(p1);

        Curso curso = new Curso();
        curso.setNome("Confeitaria Básica");
        curso.setDescricao("Curso sobre confeitaria da frança");

      
        cursoService.adicionarCurso(curso);


        Aluno aluno = new Aluno();
        aluno.setNome("caio");
        aluno.setEmail("caio@gmail.com");
        aluno.setSenha(1238);



        cursoService.matricula(curso.getId() , aluno);
        alunoRepository.save(aluno);



    }

}