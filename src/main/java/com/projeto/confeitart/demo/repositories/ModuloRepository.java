package com.projeto.confeitart.demo.repositories;

import com.projeto.confeitart.demo.model.Curso;
import com.projeto.confeitart.demo.model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    //List<Modulo> findByCurso(Curso curso);
}
