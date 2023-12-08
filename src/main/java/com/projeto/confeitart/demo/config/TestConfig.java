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
        p1.setNome("Iago Rodrigues");
        p1.setEmail("iago@gmail.com");
        p1.setSenha(2345);
        p1.setEspecializacao("Doces");

        professorRepository.save(p1);

        Curso curso = new Curso();
        curso.setNome("Confeitaria Básica");
        curso.setDescricao("Curso sobre conceitos básicos");

        // Salvar o curso no banco de dados
        cursoService.adicionarCurso(curso);


        //Curso curso1 = new Curso(5L, "Confeitaria Básica", "curso sobre conceitos básicos", p1);

        Aluno aluno = new Aluno();

        aluno.setNome("Maria");
        aluno.setEmail("maria@gmail.com");
        aluno.setSenha(1234);

        //Aluno a1 = new Aluno(1L, "Maria", "maria@gmail.com", 1234, 5L);
       // professorRepository.saveAll(Arrays.asList(p1));
        cursoService.matricula(curso.getId() , aluno);

        //p1.setCurso(curso1);

        //alunoRepository.saveAll(Arrays.asList(a1);


    }

}