
package com.senai.biblioadmin.repository;

import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
    
    Livro findByTitulo(String titulo);
    
}