
package com.senai.biblioadmin.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name="estudantes")
public class Estudante {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdEstudante;
    
    @Column(nullable=false)
    private String nome;
    
    @Column(nullable=false, unique=true)
    private Long matricula;
    
    @Column(nullable=false)
    private String email;
    
    @Column(nullable=true)
    private String telefone;
    
    @Column(nullable=false)
    private String senha;
    
    @Column(nullable = false)
    private Boolean isBiblio;
    
    @OneToMany(fetch=FetchType.LAZY, 
            orphanRemoval = true, 
            cascade = CascadeType.ALL)
    private Set<Emprestimo> emprestimo;
    
    
    // ------------------------------get and setter ------------------------------ //

    public Set<Emprestimo> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Set<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    
    
    public Long getIdEstudante() {
        return IdEstudante;
    }

    public Boolean getIsBiblio() {
        return isBiblio;
    }

    public void setIsBiblio(Boolean isBiblio) {
        this.isBiblio = isBiblio;
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
