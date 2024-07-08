/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.biblioadmin.service;

import com.senai.biblioadmin.entity.Estudante;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EstudanteServiceTest {
    @Autowired
    private EstudanteService estudanteService;
    
    private final Random random = new Random();
    
    private final String nomes[] = { "Ana", "Anita", "Anabela", "Aroldo",
                       "Braulio", "Carlos", "Diogo", "Fernando","Arnaldo", "Antonio","Abel",
                       "Giuliano", "Gary", "James", "Steave", "Drauzio", "Denis", "Evandro", "Ester",
                       "Michel", "Joe", "John", "Pedro", "Eva", "Fábio", "Gil",
                       "Taylor", "Marcos","Nora", "Yolanda", "Gilson", "Heitor", "Helio" };
    
    private final String sobrenome[] = { "Braga", "Velasques", "Gomes", "Costa",
                       "Silva", "Santos", "Biden", "Deere", "Pires", "Pereira", "Teixeira", "Trevor",
                       "Cintra", "Magalhães", "Melo", "Ribeiro","Santana", "Carvalho", "Mestieri",
                       "Oliveira", "Ferreira", "Marchi", "Rocha", "Sauro", "Mendes", "Leite", "Vilani",
                       "Santos", "Benedetti","Statan", "Collin", "Vieira", "Fernandes", "Pinheiro" };
    
    
    public EstudanteServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {

    }
    
    @AfterAll
    public static void tearDownClass() {        
        System.out.println("\n#########  Fim dos Testes #############");
        System.out.println("#######################################");
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    @Order(0)
    //@Disabled
    public void incluirEstudantes(){
  
        int qtdEstu = 120;
        System.out.println("\n# Incluindo " + qtdEstu + " estudantes aleatorios...");
        for(int i=1;i<=qtdEstu;i++){
            Estudante estud = new Estudante();
            estud.setNome(geraNomes());
            estud.setEmail( estud.getNome().replace(" ","_").toLowerCase() + "@email.com" );
            estud.setSenha("senha");
            String mat = this.geraRandomico(6);
            estud.setMatricula( Long.valueOf(mat) );
            estud.setTelefone("48" + geraRandomico(9));
            estud.setIsBiblio(false);
            estudanteService.incluirEstudante(estud);            
            assertTrue(true,"#0 Erro: Erro ao inserir estudantes, verifique... ");
        }

        
    }
    @Test
    @Order(1)
    public void incluirEstudanteMatriculaCadastrada(){
        System.out.println("\n#######################################");
        System.out.println("#######  Inicio dos Testes ############\n");
        System.out.println("#4 Incluir estudante com matricula cadastrada");
        Estudante estud = new Estudante();
        estud.setEmail("estudante@email.com");
        estud.setNome("Nome Estudante#4");
        estud.setSenha("senha");
        estud.setTelefone("48" + geraRandomico(9));
        estud.setIsBiblio(false);
        List<Estudante> listaEstud = estudanteService.listarEstudantes();
        Long matricula = listaEstud.get(0).getMatricula();
        estud.setMatricula(matricula);
        Long IdEstudante = estudanteService.incluirEstudante(estud);
        Long idEsperado = null;
        assertEquals(IdEstudante, idEsperado,"#4 ERRO: Foi inserido Estudante com matricula duplicada...");        
    }
    @Test
    @Order(3)
    //@Disabled
    public void alterarEstudanteSemMatricula(){
        System.out.println("#13 Alterar estudante sem matricula");
        Estudante estud = estudanteService.listarEstudantes().get(0);
        estud.setMatricula(null);
        estud.setNome("Nome Alterado");
        estud.setIsBiblio(false);
        Boolean result = estudanteService.alterarEstudante(estud);
        Boolean resultEsperado = false;
        assertEquals(result,resultEsperado,"#13 Erro: Foi alterado Estudante sem matricula...");
    }   
            
            

//    @Test
//    @Order(1)
//    public void testIncluirEstudante() {
//        System.out.println("incluirEstudante");
//        Estudante estudante = null;
//        EstudanteService instance = new EstudanteService();
//        Long expResult = null;
//        Long result = instance.incluirEstudante(estudante);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testLoginEstudante() {
//        System.out.println("loginEstudante");
//        Long matricula = null;
//        String senha = "";
//        EstudanteService instance = new EstudanteService();
//        Estudante expResult = null;
//        Estudante result = instance.loginEstudante(matricula, senha);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testHashSenha() {
//        System.out.println("hashSenha");
//        String passwd = "";
//        EstudanteService instance = new EstudanteService();
//        String expResult = "";
//        String result = instance.hashSenha(passwd);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testAlterarEstudante() {
//        System.out.println("alterarEstudante");
//        Estudante estudante = null;
//        EstudanteService instance = new EstudanteService();
//        boolean expResult = false;
//        boolean result = instance.alterarEstudante(estudante);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testExcluirEstudantePorId() {
//        System.out.println("excluirEstudantePorId");
//        Long IdEstudante = null;
//        EstudanteService instance = new EstudanteService();
//        boolean expResult = false;
//        boolean result = instance.excluirEstudantePorId(IdEstudante);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testExcluirEstudantePorMatricula() {
//        System.out.println("excluirEstudantePorMatricula");
//        Long matricula = null;
//        EstudanteService instance = new EstudanteService();
//        boolean expResult = false;
//        boolean result = instance.excluirEstudantePorMatricula(matricula);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testConsultaEstudantePorId() {
//        System.out.println("consultaEstudantePorId");
//        Long IdEstudante = null;
//        EstudanteService instance = new EstudanteService();
//        Estudante expResult = null;
//        Estudante result = instance.consultaEstudantePorId(IdEstudante);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testConsultaEstudantePorMatricula() {
//        System.out.println("consultaEstudantePorMatricula");
//        Long matricula = null;
//        EstudanteService instance = new EstudanteService();
//        Estudante expResult = null;
//        Estudante result = instance.consultaEstudantePorMatricula(matricula);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testConsultaEstudantePorEmail() {
//        System.out.println("consultaEstudantePorEmail");
//        String email = "";
//        EstudanteService instance = new EstudanteService();
//        Estudante expResult = null;
//        Estudante result = instance.consultaEstudantePorEmail(email);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testConsultaEstudantePorNome() {
//        System.out.println("consultaEstudantePorNome");
//        String nome = "";
//        EstudanteService instance = new EstudanteService();
//        List<Estudante> expResult = null;
//        List<Estudante> result = instance.consultaEstudantePorNome(nome);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testListarEstudante() {
//        System.out.println("listarEstudante");
//        Integer pagina = null;
//        EstudanteService instance = new EstudanteService();
//        List<Estudante> expResult = null;
//        List<Estudante> result = instance.listarEstudante(pagina);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
     public String geraRandomico(int qtd){
         
        String qtdNum = "";
        for(int i=1;i<=qtd;i++){
             qtdNum = qtdNum + "9";
        }
        int numero = random.nextInt(Integer.valueOf(qtdNum));
        String snumero = String.valueOf(numero);
        Integer dif = qtd - snumero.length();
        if( dif > 0 ){
            return (snumero+qtdNum).substring(0,qtd);            
        }
        return snumero;
    }     
    public String geraNomes(){
        int idxnome = random.nextInt(nomes.length -1);
        int idxsobre = random.nextInt(sobrenome.length -1);
        return nomes[idxnome] + " " + sobrenome[idxsobre];
    }
    
    
}