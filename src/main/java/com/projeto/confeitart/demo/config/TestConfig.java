package com.projeto.confeitart.demo.config;



import com.projeto.confeitart.demo.model.*;
import com.projeto.confeitart.demo.repositories.*;
import com.projeto.confeitart.demo.services.AlunoService;
import com.projeto.confeitart.demo.services.CategoriaService;
import com.projeto.confeitart.demo.services.CursoService;
import com.projeto.confeitart.demo.services.ModuloService;
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
    @Autowired
    PlanoRepository planoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ModuloRepository moduloRepository;
    @Autowired
    ModuloService moduloService;
//SE TIVER ALGO COMENTADO, POR FAVOR, NÃO APAGUE! THANKS
    @Override
    public void run(String... args) throws Exception {

        //Professor p1 = new Professor(2L, "Iago Rodrigues", "iago@gmail.com", 2345, "Doces");
        Professor p1 = new Professor();
        p1.setNome("Giovanna");
        p1.setEmail("Giovanna@gmail.com");
        p1.setSenha(2755);
        p1.setEspecializacao("confeitaria clássica");


        professorRepository.save(p1);

        Plano plano = new Plano();
        plano.setPlano(false);
        planoRepository.save(plano);

        Categoria categoria =new Categoria();
        categoria.setNome("Comida Cazeira");
        categoriaService.adicionarCategoria(categoria);

        Modulo modulo = new Modulo();
        modulo.setNome("Módulo 1");
        modulo.setDescricao("Descrição do Módulo 1");


        moduloService.saveModulo(modulo);

        Curso curso = new Curso();
        curso.setNome("Bolos cazeiros");
        curso.setDescricao("Curso sobre bolos cazeiros");
        curso.setPlano(plano);
        curso.setProfessor(p1);
        curso.setCategoria(categoria);
        modulo.setCurso(curso);
        cursoService.adicionarCurso(curso);



        Aluno aluno = new Aluno();
        aluno.setNome("Renan");
        aluno.setEmail("renan@gmail.com");
        aluno.setSenha(1818);
        cursoService.matricula(curso.getId() , aluno);
        alunoRepository.save(aluno);



    }

}