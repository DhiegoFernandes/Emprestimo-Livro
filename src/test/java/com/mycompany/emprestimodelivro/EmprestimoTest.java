/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.emprestimodelivro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dhieg
 */
public class EmprestimoTest {

    private Emprestimo emprestimo;
    private Livro livro;
    private Leitor leitor;
    private Atendente atendente;

    public EmprestimoTest() {

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        livro = new Livro(1, "Bridge to Terabithia", LivroEnum.DISPONIVEL);
        leitor = new Leitor(1, "Joao", 0);
        atendente = new Atendente(1, "Maria");
        emprestimo = new Emprestimo(livro, leitor, atendente);
    }

    @AfterEach
    public void tearDown() {
        emprestimo = null;
        livro = null;
        leitor = null;
        atendente = null;
    }

    @Test
    public void testRegistrarEmprestimo() {
        System.out.println("registrarEmprestimo");
        String result = emprestimo.registrarEmprestimo();
        assertNotNull(result); // verifica se o resultado não é nulo
    }

    @Test
    public void testDevolverLivro() {
        System.out.println("devolverLivro");
        LocalDate dataDevolvido = LocalDate.now();
        String result = emprestimo.devolverLivro(dataDevolvido);
        assertNotNull(result); // Verifica se o resultado não é nulo

    }

   @Test
    public void testEhValidoParaInclusao() {
        System.out.println("ehValidoParaInclusao");
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setIdEmprestimo(-1); // Definindo um ID inválido

        List<String> erros = ehValidoParaInclusao(emprestimo);
        assertFalse(erros.isEmpty(), "A lista de erros não deve estar vazia.");
        assertTrue(erros.contains("O ID do empréstimo não pode ser menor que 0."), "Erro não foi identificado corretamente.");
    }

    @Test
    public void testValidarDataEmprestimo() {
        System.out.println("validarDataEmprestimo");
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(LocalDate.now().minusDays(1)); // Definindo data no passado

        List<String> erros = validarDataEmprestimo(emprestimo);
        assertFalse(erros.isEmpty(), "A lista de erros não deve estar vazia.");
        assertTrue(erros.contains("A data de empréstimo não pode ser anterior à data atual."), "Erro não foi identificado corretamente.");
    }

    @Test
    public void testValidarDataDevolucao() {
        System.out.println("validarDataDevolucao");
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().minusDays(1)); // Definindo data de devolução no passado

        List<String> erros = validarDataDevolucao(emprestimo);
        assertFalse(erros.isEmpty(), "A lista de erros não deve estar vazia.");
        assertTrue(erros.contains("A data de devolução não pode ser igual ou anterior à data de empréstimo."), "Erro não foi identificado corretamente.");
    }
    
    
    
    // metodos auxiliares para testes
        public static List<String> ehValidoParaInclusao(Emprestimo emprestimo) {
        List<String> erros = new ArrayList<>();
        if (emprestimo.getIdEmprestimo() < 0) {
            erros.add("O ID do empréstimo não pode ser menor que 0.");
        }
        return erros;
    }

    public static List<String> validarDataEmprestimo(Emprestimo emprestimo) {
        List<String> erros = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataEmprestimo = emprestimo.getDataEmprestimo();

        if (dataEmprestimo.isBefore(dataAtual)) {
            erros.add("A data de empréstimo não pode ser anterior à data atual.");
        }
        return erros;
    }

    public static List<String> validarDataDevolucao(Emprestimo emprestimo) {
        List<String> erros = new ArrayList<>();
        LocalDate dataEmprestimo = emprestimo.getDataEmprestimo();
        LocalDate dataDevolucao = emprestimo.getDataDevolucao();

        if (dataDevolucao.isBefore(dataEmprestimo) || dataDevolucao.isEqual(dataEmprestimo)) {
            erros.add("A data de devolução não pode ser igual ou anterior à data de empréstimo.");
        }
        return erros;
    }

}
