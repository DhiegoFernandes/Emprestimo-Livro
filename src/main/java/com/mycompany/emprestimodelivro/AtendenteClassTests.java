package com.mycompany.emprestimodelivro;

import java.util.ArrayList;
import java.util.List;

public class AtendenteClassTests {

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
