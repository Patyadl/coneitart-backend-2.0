package com.projeto.confeitart.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_curso")
public class Curso  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @JsonIgnore
    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos;

    @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "plano_id")
  @JoinTable(
          name = "curso_plano",
          joinColumns = @JoinColumn(name = "curso_id"),
          inverseJoinColumns = @JoinColumn(name = "plano_id"))
    private Plano plano;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "curso_categoria",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "curso_modulo",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_id"))
    private Set<Modulo> modulos = new HashSet<>();

    public Curso(){}

    public Curso( String nome, String descricao, Professor professor , Plano plano) {

        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
