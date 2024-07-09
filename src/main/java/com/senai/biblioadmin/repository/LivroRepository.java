
package com.senai.biblioadmin.repository;


import com.senai.biblioadmin.entity.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {
    
    @Query(value="select p.id_livro , p.ano, p.autor, p.editora, p.titulo from livros p where p.titulo like :titulo%", nativeQuery=true)
    List<LivroList> findByTitulo(@Param("titulo") String titulo);
}