
//package com.senai.biblioadmin.service;
//
//import com.senai.biblioadmin.entity.Emprestimo;
//import com.senai.biblioadmin.entity.Estudante;
//import com.senai.biblioadmin.entity.Livro;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author luca_mello
// */
//public class EmprestimoServiceTest {
//    
//    public EmprestimoServiceTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//        System.out.println("\n#########  Fim dos Testes #############");
//        System.out.println("#######################################");
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of incluirEmprestimo method, of class EmprestimoService.
//     */
//    @Test
//    public void testIncluirEmprestimo() {
//        System.out.println("incluirEmprestimo");
//        Emprestimo emprestimo = null;
//        EmprestimoService instance = new EmprestimoService();
//        Long expResult = null;
//        Long result = instance.incluirEmprestimo(emprestimo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of excluirEmprestimo method, of class EmprestimoService.
//     */
////    @Test
////    public void testExcluirEmprestimo() {
////        System.out.println("excluirEmprestimo");
////        Long IdEmprestimo = null;
////        EmprestimoService instance = new EmprestimoService();
////        boolean expResult = false;
////        boolean result = instance.excluirEmprestimo(IdEmprestimo);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of consultaEmprestimoPorId method, of class EmprestimoService.
////     */
////    @Test
////    public void testConsultaEmprestimoPorId() {
////        System.out.println("consultaEmprestimoPorId");
////        Long IdEmprestimo = null;
////        EmprestimoService instance = new EmprestimoService();
////        Emprestimo expResult = null;
////        Emprestimo result = instance.consultaEmprestimoPorId(IdEmprestimo);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of consultaEmprestimoPorEstudante method, of class EmprestimoService.
////     */
////    @Test
////    public void testConsultaEmprestimoPorEstudante() {
////        System.out.println("consultaEmprestimoPorEstudante");
////        Estudante estudante = null;
////        EmprestimoService instance = new EmprestimoService();
////        Emprestimo expResult = null;
////        Emprestimo result = instance.consultaEmprestimoPorEstudante(estudante);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of consultaEmprestimoPorLivro method, of class EmprestimoService.
////     */
////    @Test
////    public void testConsultaEmprestimoPorLivro() {
////        System.out.println("consultaEmprestimoPorLivro");
////        Livro livro = null;
////        EmprestimoService instance = new EmprestimoService();
////        Emprestimo expResult = null;
////        Emprestimo result = instance.consultaEmprestimoPorLivro(livro);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of listarEmprestimos method, of class EmprestimoService.
////     */
////    @Test
////    public void testListarEmprestimos() {
////        System.out.println("listarEmprestimos");
////        EmprestimoService instance = new EmprestimoService();
////        List<Emprestimo> expResult = null;
////        List<Emprestimo> result = instance.listarEmprestimos();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of alterarEmprestimo method, of class EmprestimoService.
////     */
////    @Test
////    public void testAlterarEmprestimo() {
////        System.out.println("alterarEmprestimo");
////        Emprestimo emprestimo = null;
////        EmprestimoService instance = new EmprestimoService();
////        boolean expResult = false;
////        boolean result = instance.alterarEmprestimo(emprestimo);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    
//}
