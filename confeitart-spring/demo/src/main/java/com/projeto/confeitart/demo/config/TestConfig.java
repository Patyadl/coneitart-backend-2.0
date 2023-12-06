package com.projeto.confeitart.demo.config;



import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration //especifica que é uma classe de configuração
@Profile("test") //identifica que roda apenas no perfil de teste


public class TestConfig implements CommandLineRunner {

    @Autowired // associa a dependencia a instancia de UsuarioRepository
    private UsuarioRepository usuarioRepository;

  


    @Override
    public void run(String... args) throws Exception {
      Aluno u1 = new Aluno(1L,"Maria" , "maria@gmail.com" , 3455);
        Aluno u2 = new Aluno(1L,"Marcos" , "marcos@gmail.com" , 3456);


    }
}