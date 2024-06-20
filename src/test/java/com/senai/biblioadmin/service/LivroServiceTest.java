/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.biblioadmin.service;

import com.senai.biblioadmin.entity.Livro;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luca_mello
 */
public class LivroServiceTest {
    
    public LivroServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of incluirLivro method, of class LivroService.
     */
    @Test
    public void testIncluirLivro() {
        System.out.println("incluirLivro");
        Livro livro = null;
        LivroService instance = new LivroService();
        Long expResult = null;
        Long result = instance.incluirLivro(livro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluirLivro method, of class LivroService.
     */
    @Test
    public void testExcluirLivro() {
        System.out.println("excluirLivro");
        Long IdLivro = null;
        LivroService instance = new LivroService();
        boolean expResult = false;
        boolean result = instance.excluirLivro(IdLivro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCliente method, of class LivroService.
     */
    @Test
    public void testListarCliente() {
        System.out.println("listarCliente");
        LivroService instance = new LivroService();
        List<Livro> expResult = null;
        List<Livro> result = instance.listarCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarLivro method, of class LivroService.
     */
    @Test
    public void testAlterarLivro() {
        System.out.println("alterarLivro");
        Livro livro = null;
        LivroService instance = new LivroService();
        boolean expResult = false;
        boolean result = instance.alterarLivro(livro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
