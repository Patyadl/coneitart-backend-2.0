package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Categoria;
import com.projeto.confeitart.demo.repositories.CategoriaRepository;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CursoRepository cursoRepository;



    public void adicionarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }
}
