package com.projeto.confeitart.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno extends Usuario implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Plano plano;
    //private Curso curso;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "aluno_curso",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;

    public Aluno(){}

    public Aluno(Long id) {
        this.id = id;

    }

    public Aluno( String nome, String email, int senha, Long id_curso) {
        super( nome, email, senha);

        // Agora, o ID do curso deve ser atribuído ao curso diretamente, não ao ID do aluno
        this.cursos = new ArrayList<>();
        if (id_curso != null) {
            Curso curso = new Curso();
            curso.setId(id_curso);
            this.cursos.add(curso);
        }
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
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
