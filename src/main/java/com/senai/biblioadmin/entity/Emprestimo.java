package com.senai.biblioadmin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdEmprestimo;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "livro_id_livro", referencedColumnName = "IdLivro")
    private Livro livro;

    @ManyToOne(fetch=FetchType.EAGER)
    private Estudante estudante;

    @Column(nullable = false)
    private Date dataEmprestimo;

    @Column(nullable = false)
    private Date dataEntrega;

    @Column(nullable = true)
    private String devolucao;

    // GETS AND SETTERS

    public Long getIdEmprestimo() {
        return IdEmprestimo;
    }

    public void setIdEmprestimo(Long IdEmprestimo) {
        this.IdEmprestimo = IdEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
