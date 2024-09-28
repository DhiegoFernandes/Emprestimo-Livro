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
public class LeitorTest {

    public LeitorTest() {
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
    public void testEhValidoParaInclusao_Valido() {
        // Testa um leitor válido
        Leitor leitor = new Leitor(1, "João Silva", 12345);
        List<String> erros = ehValidoParaInclusao(leitor);
        assertTrue(erros.isEmpty()); //Sem erros
    }

    @Test
    public void testEhValidoParaInclusao_NomeInvalido() {
        // Testa um leitor com nome inválido
        Leitor leitor = new Leitor(2, "!@#!#!$!", 12345); //nome invalido
        List<String> erros = ehValidoParaInclusao(leitor);
        assertFalse(erros.isEmpty()); //Verifica se há erros para nome invalido (deve haver erros)
        assertEquals("O nome deve conter ao menos 2 letras e apenas letras.", erros.get(0));
    }

    @Test
    public void testEhValidoParaInclusao_IdInvalido() {
        // Testa um leitor com ID inválido
        Leitor leitor = new Leitor(-1, "Maria da Silva", 12345);
        List<String> erros = ehValidoParaInclusao(leitor);
        assertFalse(erros.isEmpty()); // verifica se há erros para idInvalido (deve haver erros)
        assertEquals("O ID deve ser um número positivo.", erros.get(0));
    }

    
    
    // metodos auxiliares para testes
    public static List<String> ehValidoParaInclusao(Leitor leitor) {
        List<String> erros = new ArrayList<>();

        String[] partesNome = leitor.getNome().split(" ");
        if (partesNome.length < 2 || !nomeValido(partesNome)) {
            erros.add("O nome deve conter ao menos 2 letras e apenas letras.");
        }

        if (!idValido(leitor.getIdCarteiraDeIdentificacao())) {
            erros.add("O ID deve ser um número positivo.");
        }

        return erros;
    }

    private static boolean nomeValido(String[] partesNome) {
        for (String parte : partesNome) {
            if (!parte.chars().allMatch(Character::isLetter)) {
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
