
package com.senai.biblioadmin.service;

import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.repository.EmprestimoRepository;
import com.senai.biblioadmin.repository.EstudanteRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.lang.Integer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudanteService {
    
   
    
    
   @Autowired
   private EstudanteRepository estudanteRepository;
    
   @Value("${biblio.registros.pag}")
   private int regPaginas;
    
   private Pageable pageable;
   
   
   public Long incluirEstudante(Estudante estudante){
        
        if(estudante.getMatricula() == null || estudante.getNome() == null ||
           estudante.getSenha() == null || estudante.getEmail() == null){
            return null;
        }
        if(estudanteRepository.findByMatricula(estudante.getMatricula()) != null){
            return null;
        }
        
        String senhaCod = hashSenha(estudante.getSenha());
        estudante.setSenha(senhaCod);
        return estudanteRepository.save(estudante).getIdEstudante();
    }
    
   public Estudante loginEstudante(Long matricula, String senha){
        
        String senhaHash = "";
        Estudante estudanteBD = estudanteRepository.findByMatricula(matricula);
        if(estudanteBD != null){
            senhaHash = hashSenha(senha);
            String senhaBD = estudanteBD.getSenha();
            
            if( senhaHash.equals(senhaBD) ){               
               return estudanteBD;
            }
        }        
        return null;
    }
    
    
    public String hashSenha(String passwd){
        String passwdCod = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //md. update(salt);
            final byte[] hashBytes = md.digest(passwd.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hashBytes.length; i++) {
                sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwdCod = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getLocalizedMessage();
        }
        return passwdCod;
    }
    


    
     @Transactional
        public boolean excluirEstudante(Long idEstudante) {
        Optional<Estudante> estudanteOptional = estudanteRepository.findById(idEstudante);

        if (estudanteOptional.isPresent()) {
            Estudante estudante = estudanteOptional.get();
            estudante.getEmprestimo().clear();
            estudanteRepository.delete(estudante);
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
    
    
    public List<Estudante> listarEstudantes(Integer pagina){
       
       if(pagina == null || pagina == 0) { pagina = 1; } 
       pagina = (pagina -1);
       Pageable pagsort = PageRequest.of(pagina,regPaginas,Sort.by("nome").ascending());
       List<Estudante> lestud = estudanteRepository.findAll(pagsort).getContent();
       if(lestud.isEmpty()){
           return null;
       } else {
           return lestud;
       }
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
            estBD.setTelefone(estudante.getTelefone());
            estBD.setMatricula(estudante.getMatricula());
            estBD.setEmail(estudante.getEmail());
            estBD.setSenha(estudante.getSenha());
            estBD.setNome(estudante.getNome());
            estBD.setIsBiblio(estudante.getIsBiblio());
            
            estudanteRepository.save(estBD);
            return true;           
            }
            return false;
        }
}
