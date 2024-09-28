package com.mycompany.emprestimodelivro;

import static com.mycompany.emprestimodelivro.LivroEnum.*;
import java.time.LocalDate;
import java.util.Scanner;

public class EmprestimoDeLivro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Livro livro1 = new Livro(1, "Bridge to Terabithia", DISPONIVEL);
        Leitor leitor1 = new Leitor(1, null, 0);
        Atendente at1 = new Atendente(1, "Maria");

        System.out.println(livro1);
        System.out.println(leitor1);
        System.out.println(at1);

        Emprestimo emp1 = null;
        while (true) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1. Registrar empréstimo");
            System.out.println("2. Verificar disponibilidade do livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Fechar sistema");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Registrar empréstimo
                    boolean situacao = at1.validarIdentificacaoLeitor(leitor1);
                    if (situacao) {
                        emp1 = new Emprestimo(livro1, leitor1, at1);
                        System.out.println("Emprestimo:" + emp1 + "\n");
                        System.out.println(emp1.registrarEmprestimo());
                    } else {
                        System.out.println("Identificação inválida. Operação cancelada.");
                    }
                    break;

                case 2:
                    // Verificar disponibilidade do livro
                    System.out.println(livro1.verificarDisponibilidade());
                    break;

                case 3:
                    // Devolver livro
                    if (emp1 != null) {
                        System.out.println(emp1.devolverLivro(LocalDate.now()));
                        emp1 = null; // Zera o empréstimo após a devolução
                    } else {
                        System.out.println("Nenhum livro emprestado para devolução.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }
    }

}
