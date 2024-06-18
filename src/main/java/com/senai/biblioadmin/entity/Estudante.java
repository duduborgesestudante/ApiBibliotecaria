
package com.senai.biblioadmin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="estudantes")
public class Estudante {
    
    @Id 
    @OneToMany
    private Long IdEstudante;
    
    @Column(nullable=false)
    private String nome;
    
    @Column(nullable=false)
    private Long matricula;
    
    @Column(nullable=false)
    private String email;
    
    @Column(nullable=true)
    private String telefone;
    
    @Column(nullable=false)
    private String senha;
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
    
}
