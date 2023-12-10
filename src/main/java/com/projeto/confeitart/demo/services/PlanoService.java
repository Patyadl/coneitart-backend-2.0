package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Plano;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import com.projeto.confeitart.demo.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

 @Autowired
    private PlanoRepository planoRepository;


    private CursoRepository cursoRepository;

    @Autowired
   public PlanoService(PlanoRepository planoRepository,CursoRepository cursoRepository){
        this.planoRepository =planoRepository;
        this.cursoRepository= cursoRepository;
    }
    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }

    public void adicionarPlano(Plano plano){
        planoRepository.save(plano);
    }
    public void deletarPlano(Long id ){
        planoRepository.deleteById(id);}
    public Plano getPlanoById(Long id) {
        return planoRepository.findById(id).orElse(null);
    }


}
