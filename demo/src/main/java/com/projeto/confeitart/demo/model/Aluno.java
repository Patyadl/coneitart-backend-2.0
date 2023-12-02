package com.projeto.confeitart.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Usuario implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Plano plano;
    //private List<Curso> cursos;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    public Aluno(){}

    public Aluno(Long id) {
        this.id = id;

    }

    public Aluno(Long id, String nome, String email, int senha) {
        super(id, nome, email, senha);
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
