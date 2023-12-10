package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.model.Professor;
import com.projeto.confeitart.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService extends UsuarioService{

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }
    public Professor salvarProfessor(Professor professor , Curso curso){
        professor.setCurso(curso);
        return professorRepository.save(professor);
    }
    public void deletarprofessor(Long id){
        professorRepository.deleteById(id);}

    public void atualizarProfessor(Long id , Professor professorAtualizado){
        Optional<Professor> obj = professorRepository.findById(id);
        if (obj.isPresent()){
            Professor professor = obj.get();

            professor.setNome(professorAtualizado.getNome());
            professor.setEmail(professorAtualizado.getEmail());
            professor.setSenha(professorAtualizado.getSenha());
        }
    }
    public void salvarSenha(long id , int senha){
        String tamanho = String.valueOf(senha);
        if (tamanho.length() == 4){
            Optional<Professor> obj = professorRepository.findById(id);
            if (obj.isPresent()) {
                Professor professor= obj.get();
                professor.setSenha(senha);
                professorRepository.save(professor);

            }
        }
    }


    @Override
    public void alterarSenha(long id ,int novaSenha){
        Optional<Professor> obj = professorRepository.findById(id);
        Professor professor;
        if (obj.isPresent()){
            professor = obj.get();
           professor.setSenha(novaSenha);
            professorRepository.save(professor);
        }
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }
    
}
