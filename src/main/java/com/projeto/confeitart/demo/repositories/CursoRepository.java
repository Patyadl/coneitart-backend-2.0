package com.projeto.confeitart.demo.repositories;

import com.projeto.confeitart.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso , Long> {

}
