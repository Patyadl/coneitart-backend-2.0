package com.projeto.confeitart.demo.repositories;

import com.projeto.confeitart.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.alunos WHERE c.id = :cursoId")
    Optional<Curso> findByIdWithAlunos(@Param("cursoId") Long cursoId);
}
