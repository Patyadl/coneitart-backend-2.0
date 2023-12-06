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
    private Curso cursos;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "matricula",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Curso curso;
    public Aluno(){}

    public Aluno(Long id) {
        this.id = id;

    }

    public Aluno(Long id, String nome, String email, int senha,Curso curso) {
        super(id, nome, email, senha);
this.curso = curso;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCursos() {
        return cursos;
    }

    public void setCursos(Curso cursos) {
        this.cursos = cursos;
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
