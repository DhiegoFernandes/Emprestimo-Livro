package com.mycompany.emprestimodelivro;

import static com.mycompany.emprestimodelivro.LivroEnum.*;

public class EmprestimoDeLivro {

    public static void main(String[] args) {

        Livro livro1 = new Livro(0, "titulo", DISPONIVEL);

        Leitor leitor1 = new Leitor(0, "João", 0);

        Atendente at1 = new Atendente(0, "Cleber");

        System.out.println(livro1);
        System.out.println(leitor1);
        System.out.println(at1);

        Emprestimo e = new Emprestimo();
        
        e.registrarEmprestimo();

    }
}
