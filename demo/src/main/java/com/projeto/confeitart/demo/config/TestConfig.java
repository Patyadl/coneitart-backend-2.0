package com.projeto.confeitart.demo.config;



import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Professor;
import com.projeto.confeitart.demo.repositories.AlunoRepository;
import com.projeto.confeitart.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration //especifica que é uma classe de configuração
public class TestConfig implements CommandLineRunner {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {
        Aluno a1 = new Aluno( 1L ,"Maria" , "maria@gmail.com" , 1234 );
        Professor p1 = new Professor(1L ," Iago Rodrigues" ,"iago@gmail.com" ,2345 ,"Doces"  );

        alunoRepository.saveAll(Arrays.asList(a1));
        professorRepository.saveAll(Arrays.asList(p1));
    }

}