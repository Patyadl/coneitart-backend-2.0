package com.projeto.confeitart.demo.repositories;

import com.projeto.confeitart.demo.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

}
