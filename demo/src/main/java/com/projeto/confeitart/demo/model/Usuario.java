package com.projeto.confeitart.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int senha;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Aluno> alunos;

    public Usuario(){}

    public Usuario(Long id, String nome, String email, int senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario user = (Usuario) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
