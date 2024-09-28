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
public class AtendenteTest {

    public AtendenteTest() {
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
    public void testValidarIdentificacaoLeitor_Valido() {
        System.out.println("validarIdentificacaoLeitor - Leitor Válido");
        Leitor leitor = new Leitor(1, "João", 0); // Leitor válido
        Atendente instance = new Atendente(1, "Maria");

        boolean expResult = true; // Espera true
        boolean result = instance.validarIdentificacaoLeitor(leitor);
        assertEquals(expResult, result, "A validação deve retornar verdadeiro para um leitor válido.");
    }

    @Test
    public void testValidarIdentificacaoLeitor_Invalido() {
        System.out.println("validarIdentificacaoLeitor - Leitor Inválido");
        Leitor leitor = new Leitor(-1, "Ninguém", 0); // ID inválido
        Atendente instance = new Atendente(1, "Maria");

        boolean expResult = false; // Espera false
        boolean result = instance.validarIdentificacaoLeitor(leitor);
        assertEquals(expResult, result, "Deve retornar false para um leitor inválido.");
    }

    @Test
    public void testEhValidoParaInclusao_Valido() {
        Atendente atendente = new Atendente(1, "Maria Silva");
        List<String> erros = ehValidoParaInclusao(atendente);

        assertTrue(erros.isEmpty(), "Não deve haver erros para um atendente válido.");
    }

    @Test
    public void testEhValidoParaInclusao_NomeInvalido() {
        Atendente atendente = new Atendente(2, "Jo"); // Nome inválido (muito curto)
        List<String> erros = ehValidoParaInclusao(atendente);

        assertFalse(erros.isEmpty(), "Deve haver um erro para o nome inválido.");
        assertTrue(erros.contains("O nome deve conter ao menos 2 letras e apenas letras."),
                "Erro não identificado.");
    }

    @Test
    public void testEhValidoParaInclusao_NomeComNumeros() {
        Atendente atendente = new Atendente(3, "João123 Silva"); // Nome com números
        List<String> erros = ehValidoParaInclusao(atendente);

        assertFalse(erros.isEmpty(), "Deve haver um erro para o nome com números.");
        assertTrue(erros.contains("O nome deve conter ao menos 2 letras e apenas letras."),
                "Erro não foi identificado corretamente.");
    }

    @Test
    public void testEhValidoParaInclusao_IdInvalido() {
        Atendente atendente = new Atendente(-1, "Maria Silva"); // ID inválido
        List<String> erros = ehValidoParaInclusao(atendente);

        assertFalse(erros.isEmpty(), "Deve haver um erro para o ID inválido.");
        assertTrue(erros.contains("O ID deve ser um número positivo."),
                "Erro não identificado.");
    }

    // metodos de auxiliares para testes
    public static List<String> ehValidoParaInclusao(Atendente atendente) {
        List<String> erros = new ArrayList<>();

        String[] partesNome = atendente.getNome().split(" ");
        if (partesNome.length < 2 || !nomeValido(partesNome)) {
            erros.add("O nome deve conter ao menos 2 letras e apenas letras.");
        }

        if (!idValido(atendente.getIdAtendente())) {
            erros.add("O ID deve ser um número positivo.");
        }

        return erros;
    }

    private static boolean nomeValido(String[] partesNome) {
        for (String parte : partesNome) {
            if (!parte.chars().allMatch(Character::isLetter)) { //Verifica se o nome só tem letras
                return false;
            }
        }
        return true;
    }

    private static boolean idValido(int id) {
        // Verifica se o ID é um número positivo
        return id >= 0;
    }

}
