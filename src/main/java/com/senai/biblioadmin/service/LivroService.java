package com.senai.biblioadmin.service;

import com.senai.biblioadmin.entity.Livro;
import com.senai.biblioadmin.repository.EmprestimoRepository;
import com.senai.biblioadmin.repository.LivroList;
import com.senai.biblioadmin.repository.LivroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    
    public Long incluirLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            return null;
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            return null;
        }
        if (livro.getEditora() == null || livro.getEditora().isEmpty()) {
            return null;
        }
        if (livro.getAno() == null || livro.getAno().isEmpty()) {
            return null;
        }
        return livroRepository.save(livro).getIdLivro();
    }
    
    @Transactional
    public boolean excluirLivro(Long idLivro) {
        if (livroRepository.findById(idLivro).isPresent()) {
            livroRepository.deleteById(idLivro);
            return true;
        }
        return false;
    }
    
    public List<Livro> listarLivro() {
        return livroRepository.findAll();
    }
     
    public boolean alterarLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            return false;
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            return false;
        }
        if (livro.getEditora() == null || livro.getEditora().isEmpty()) {
            return false;
        }
        if (livro.getAno() == null || livro.getAno().isEmpty()) {
            return false;
        }
         
        Livro cliBD = livroRepository.getReferenceById(livro.getIdLivro());
       
        if (cliBD != null) {
            cliBD.setTitulo(livro.getTitulo());
            cliBD.setAutor(livro.getAutor());
            cliBD.setEditora(livro.getEditora());
            cliBD.setAno(livro.getAno());
        
            livroRepository.save(cliBD);
            return true;
        }
        return false;
    }
    
    public List<LivroList> consultaLivroPorTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }
    public Livro consultarLivroPorId(Long IdLivro){
       return livroRepository.findById(IdLivro).get();
   }
}
