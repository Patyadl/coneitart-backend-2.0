package com.projeto.confeitart.demo.services;


import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.repositories.AlunoRepository;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class AlunoService extends UsuarioService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

   // private List<Curso> cursos = new ArrayList<>();

     public Aluno salvarAluno(Aluno aluno){
         return alunoRepository.save(aluno);
     }
   public void deletarAluno(Long id ){
         alunoRepository.deleteById(id);}

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }


    public void atualizarAluno(Long id , Aluno alunoAtualizado){
       Optional<Aluno> obj = alunoRepository.findById(id);
       if (obj.isPresent()){
           Aluno aluno = obj.get();

           aluno.setNome(alunoAtualizado.getNome());
           aluno.setEmail(alunoAtualizado.getEmail());
           aluno.setSenha(alunoAtualizado.getSenha());
       }
   }
    public void salvarSenha(long id , int senha){
        String tamanho = String.valueOf(senha);
        if (tamanho.length() == 4){
            Optional<Aluno> obj = alunoRepository.findById(id);
            if (obj.isPresent()) {
                Aluno aluno = obj.get();
                aluno.setSenha(senha);
                alunoRepository.save(aluno);
            }
        }
    }
     @Override
    public void alterarSenha(long id ,int novaSenha){
         Optional<Aluno> obj = alunoRepository.findById(id);
         Aluno aluno;
         if (obj.isPresent()){
         aluno = obj.get();
             aluno.setSenha(novaSenha);
             alunoRepository.save(aluno);
         }
     }

    public void matricularAluno(Curso curso, Aluno aluno) {
        // Certifique-se de que a lista de cursos não seja nula
        if (aluno.getCursos() == null) {
            aluno.setCursos(new ArrayList<>());
        }

        // Adicione o curso à lista de cursos do aluno
        aluno.getCursos().add(curso);

        // Certifique-se de que a lista de alunos do curso não seja nula
        if (curso.getAlunos() == null) {
            curso.setAlunos(new ArrayList<>());
        }
    }
    public List<Curso> getCursos(Long alunoId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        return alunoOptional.map(Aluno::getCursos).orElse(Collections.emptyList());
    }
    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }



}
