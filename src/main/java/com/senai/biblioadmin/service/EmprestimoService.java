package com.senai.biblioadmin.service;

import com.senai.biblioadmin.entity.Emprestimo;
import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.entity.Livro;
import com.senai.biblioadmin.repository.EmprestimoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EmprestimoService {
    
   @Autowired
   private EmprestimoRepository emprestimoRepository;
   
    public Long incluirEmprestimo(Emprestimo emprestimo){
        if(emprestimo.getLivro() == null ){
            return null;
        }
        if(emprestimo.getMatricula() == null ){
            return null;
        }
        if(emprestimo.getIdEmprestimo() == null ){
            return null;
        }
        if(emprestimo.getEstudante() == null ){
            return null;
        }
        if(emprestimo.getDevolucao() == null || emprestimo.getDevolucao() == ""){
            return null;
        }
        return emprestimoRepository.save(emprestimo).getIdEmprestimo();      
    }
    
    public boolean excluirEmprestimo(Long IdEmprestimo){
        if(emprestimoRepository.findById(IdEmprestimo).isPresent()){
            emprestimoRepository.deleteById(Id);
            return true;
        }
        return false;
    }
    
    public Emprestimo consultaEmprestimoPorId(Long IdEmprestimo){
        return emprestimoRepository.findById(IdEmprestimo).get();
    }
    
    public Emprestimo consultaEmprestimoPorEstudante(Estudante estudante){
        return emprestimoRepository.findByEstudante(estudante);
    }
    public Emprestimo consultaEmprestimoPorLivro(Livro livro){
        return emprestimoRepository.findByLivro(livro);
    }
    
    public List<Emprestimo> listarEmprestimos(){
        
        return emprestimoRepository.findAll();
    }
    
    public boolean alterarEmprestimo(Emprestimo emprestimo){

        if(cliente.getNome() == null || cliente.getNome() == ""){
            return false;
        }
        if(cliente.getEmail() == null || cliente.getEmail() == ""){
            return false;
        }
        if(cliente.getCpf() == null ||
           cliente.getCpf() == "" ||
           cliente.getCpf().length() != 11 ||
           ! cliente.getCpf().chars().allMatch(Character::isDigit)){
            return false;
        }
        
        Cliente cliBD = clienteRepository.getReferenceById(cliente.getIdCliente());
        if( cliBD != null){
            if(cliBD.getCpf() != cliente.getCpf() &&
                clienteRepository.findByCpf(cliente.getCpf()) != null){
                return false;
            }
            cliBD.setCelular(cliente.getCelular());
            cliBD.setCpf(cliente.getCpf());
            cliBD.setEmail(cliente.getEmail());
            cliBD.setNascimento(cliente.getNascimento());
            cliBD.setNome(cliente.getNome());
            clienteRepository.save(cliBD);
            return true;           
            }
            return false;
        }
       
}
