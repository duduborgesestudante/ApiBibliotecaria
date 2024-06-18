
package com.senai.biblioadmin.repository;

import com.senai.biblioadmin.entity.Emprestimo;
import com.senai.biblioadmin.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante,Long> {
    
    Estudante findByEmail(String email);
    Estudante findByMatricula(Long matricula);
}

