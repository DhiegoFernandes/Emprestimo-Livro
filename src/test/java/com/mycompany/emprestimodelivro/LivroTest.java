/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.emprestimodelivro;

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
public class LivroTest {

    public LivroTest() {
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

    @Test
    public void testVerificarDisponibilidade_Disponivel() {
        System.out.println("verificarDisponibilidade - disponível");
        Livro livro = new Livro(1, "O Senhor dos Anéis", LivroEnum.DISPONIVEL);
        String expResult = "O livro O Senhor dos Anéis está disponível."; //Espera disponibilidade
        String result = livro.verificarDisponibilidade();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerificarDisponibilidade_Indisponivel() {
        System.out.println("verificarDisponibilidade - indisponível");
        Livro livro = new Livro(2, "1984", LivroEnum.INDISPONIVEL);
        String expResult = "O livro 1984 está indisponível."; // espera indisponibilidade
        String result = livro.verificarDisponibilidade();
        assertEquals(expResult, result);
    }

    @Test
    public void testEhValidoParaInclusao_Valido() {
        // Testa um livro com ID válido
        Livro livro = new Livro(1, "O Senhor dos Anéis", LivroEnum.DISPONIVEL);
        List<String> erros = ehValidoParaInclusao(livro);
        assertTrue(erros.isEmpty()); // não espera erro
    }

    @Test
    public void testEhValidoParaInclusao_IdInvalido() {
        // Testa um livro com ID inválido
        Livro livro = new Livro(-1, "1984", LivroEnum.DISPONIVEL);
        List<String> erros = ehValidoParaInclusao(livro);
        assertFalse(erros.isEmpty()); // Espera erro
        assertEquals("O ID do livro não pode ser menor que 0.", erros.get(0));
    }

    @Test
    public void testValidarNumeroDeLivros_NegativoEmprestados() {
        int numeroLivrosEmprestados = -1;
        int numeroLivrosDisponiveis = 5;
        List<String> erros = validarNumeroDeLivros(numeroLivrosEmprestados, numeroLivrosDisponiveis);
        assertFalse(erros.isEmpty()); //Espera erro
        assertEquals("O número de livros emprestados não pode ser menor que 0.", erros.get(0));
    }

    // metodos auxiliares para teste
    public static List<String> ehValidoParaInclusao(Livro livro) {
        List<String> erros = new ArrayList<>();

        if (livro.getIdLivro() < 0) {
            erros.add("O ID do livro não pode ser menor que 0.");
        }

        return erros;
    }

    public static List<String> validarNumeroDeLivros(int numeroLivrosEmprestados, int numeroLivrosDisponiveis) {
        List<String> erros = new ArrayList<>();

        if (numeroLivrosEmprestados < 0) {
            erros.add("O número de livros emprestados não pode ser menor que 0.");
        }

        if (numeroLivrosEmprestados >= numeroLivrosDisponiveis) {
            erros.add("O número de livros emprestados não pode ser maior ou igual ao número de livros disponíveis.");
        }

        return erros;
    }

}
