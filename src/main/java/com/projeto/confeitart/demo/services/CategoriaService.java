package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Aluno;
import com.projeto.confeitart.demo.model.Categoria;
import com.projeto.confeitart.demo.repositories.CategoriaRepository;
import com.projeto.confeitart.demo.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    public void adicionarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long id ){
        categoriaRepository.deleteById(id);}
}
