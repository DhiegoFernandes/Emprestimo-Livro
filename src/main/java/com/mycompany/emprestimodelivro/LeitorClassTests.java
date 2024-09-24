package com.mycompany.emprestimodelivro;

import java.util.ArrayList;
import java.util.List;

public class LeitorClassTests {

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
