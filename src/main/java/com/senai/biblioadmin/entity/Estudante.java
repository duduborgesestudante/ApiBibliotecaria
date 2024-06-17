
package com.senai.biblioadmin.entity;

import jakarta.persistence.Entity;

@Entity
public class Estudante {

    public Long getIdEstudante() {
        return IdEstudante;
    }

    public void setIdEstudante(Long IdEstudante) {
        this.IdEstudante = IdEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Long getEmail() {
        return email;
    }

    public void setEmail(Long email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    private Long IdEstudante;
    
    private String nome;
    
    private Long matricula;
    
    private Long email;
    
    private String telefone;

    private String senha;
    
}
