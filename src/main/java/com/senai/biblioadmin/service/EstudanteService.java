
package com.senai.biblioadmin.service;

import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.repository.EstudanteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {
    private EstudanteRepository estudanteRepository;
    
     public Long incluirEstudante(Estudante estudante){
        if(estudante.getNome() == null || estudante.getNome() == ""){   
            return null;
        }
        if(estudante.getEmail() == null || estudante.getEmail() == ""){
            return null;
        }
        if(estudante.getMatricula() == null){
            return null;
        }
        if(estudante.getSenha() == null || estudante.getSenha() == ""){
            return null;
        }
        if(estudanteRepository.findByMatricula(estudante.getMatricula()) == null){
            return estudanteRepository.save(estudante).getIdEstudante();
        }
        return null;
    }
    
    public boolean excluirEstudante(Long IdEstudante){
        if(estudanteRepository.findById(IdEstudante).isPresent()){
            estudanteRepository.deleteById(IdEstudante);
            return true;
        }
        return false;
    }
    
    public Estudante consultaEstudantePorId(Long IdEstudante){
        return estudanteRepository.findById(IdEstudante).get();
    }
    
    public Estudante consultaEstudantePorMatricula(Long matricula){
        return estudanteRepository.findByMatricula(matricula);
    }
    
    public List<Estudante> listarEstudantes(){
        
        return estudanteRepository.findAll();
    }
    
    public boolean alterarEstudante(Estudante estudante){

        if(estudante.getNome() == null || estudante.getNome() == ""){
            return false;
        }
        if(estudante.getEmail() == null || estudante.getEmail() == ""){
            return false;
        }
        if(estudante.getMatricula() == null){
            return false;
        }
        
        Estudante estBD = estudanteRepository.getReferenceById(estudante.getIdEstudante());
        if(estBD != null){
            if(estBD.getMatricula() != estudante.getMatricula() &&
                estudanteRepository.findByMatricula(estudante.getMatricula()) != null){
                return false;
            }
            estBD.setTelefone(estudante.getTelefone());
            estBD.setMatricula(estudante.getMatricula());
            estBD.setEmail(estudante.getEmail());
            estBD.setSenha(estudante.getSenha());
            estBD.setNome(estudante.getNome());
            estudanteRepository.save(estBD);
            return true;           
            }
            return false;
        }
}
