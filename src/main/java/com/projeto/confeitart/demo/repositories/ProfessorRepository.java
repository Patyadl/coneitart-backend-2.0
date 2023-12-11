package com.projeto.confeitart.demo.repositories;

import com.projeto.confeitart.demo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository <Professor,Long>{}
