package com.projeto.confeitart.demo.services;


import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.confeitart.demo.services.UsuarioService;
import java.util.Optional;

@Service
public class AlunoService extends UsuarioService {

    @Autowired
    private AlunoRepository alunoRepository;

     public Aluno salvarAluno(Aluno aluno){
         return alunoRepository.save(aluno);
     }
   // public void deletarAluno(Long id){
       //   alunoRepository.delete(id);}

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

}
