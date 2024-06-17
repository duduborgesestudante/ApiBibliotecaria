
package com.senai.biblioadmin.repository;

import com.senai.biblioadmin.entity.Emprestimo;
import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
    
    Emprestimo findByEstudante(Estudante estudante);
    Emprestimo findByLivro(Livro livro);
    
}
