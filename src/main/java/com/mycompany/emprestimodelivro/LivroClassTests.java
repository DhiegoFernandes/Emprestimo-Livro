package com.mycompany.emprestimodelivro;

import java.util.ArrayList;
import java.util.List;

public class LivroClassTests {

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
