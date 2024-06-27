package com.senai.biblioadmin.controller;

import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.entity.Login;
import com.senai.biblioadmin.service.EstudanteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joao_cappeletti
 */
@RestController
public class EstudanteController {
    
     @Autowired
    private EstudanteService estudanteService;
    
    
    @PostMapping("/estudante")
    public ResponseEntity<Long> incluirEstudante(@RequestBody Estudante estudante){
        
        Long IdEstudante = estudanteService.incluirEstudante(estudante);
        if(IdEstudante != null){
            return new ResponseEntity<>(IdEstudante,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);        
    }
    
    @PostMapping("/estudante/login")
    public ResponseEntity<Estudante> loginEstudante(@RequestBody Login login){
        
        Estudante estudante = estudanteService.loginEstudante(login.getMatricula(),login.getSenha());
      
        if(estudante != null){
            return new ResponseEntity<>(estudante,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);        
    }
    @GetMapping("/estudante")
    public ResponseEntity<List<Estudante>> listarEstudantes(){
        List<Estudante> listEst = estudanteService.listarEstudantes();
        if(! listEst.isEmpty()){
            return new ResponseEntity<>(listEst,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/estudante/matricula/{matricula}")
    public ResponseEntity<Estudante> consultaEstudantePorMatricula(
                                   @PathVariable("matricula") Long matricula){
        Estudante estudante = estudanteService.consultaEstudantePorMatricula(matricula);
        if(estudante != null){
            return new ResponseEntity<>(estudante,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/estudante/{IdEstudante}")
    public ResponseEntity<Long> excluirEstudante(@PathVariable ("IdEstudante")Long IdEstudante){
        if(estudanteService.excluirEstudante(IdEstudante)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/estudante")
    public ResponseEntity<Boolean> alterarEstudante(@RequestBody Estudante estudante){
        
        if(estudanteService.alterarEstudante(estudante)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}