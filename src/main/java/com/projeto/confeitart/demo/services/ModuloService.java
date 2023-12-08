package com.projeto.confeitart.demo.services;

import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.model.Modulo;
import com.projeto.confeitart.demo.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> getAllModulos() {
        return moduloRepository.findAll();
    }

    public Modulo getModuloById(Long id) {
        return moduloRepository.findById(id).orElse(null);
    }

    public List<Modulo> getModulosByCurso(Curso curso) {
        return moduloRepository.findByCurso(curso);
    }

    public Modulo saveModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public void deleteModulo(Long id) {
        moduloRepository.deleteById(id);
    }
}
