/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.biblioadmin.controller;

import com.senai.biblioadmin.entity.Estudante;
import com.senai.biblioadmin.entity.Login;
import com.senai.biblioadmin.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author joao_cappeletti
 */
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
    
}
