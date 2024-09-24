package com.mycompany.emprestimodelivro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoClassTests {

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
        LocalDate dataEmprestimo = LocalDate.parse(emprestimo.getDataEmprestimo(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (dataEmprestimo.isBefore(dataAtual)) {
            erros.add("A data de empréstimo não pode ser anterior à data atual.");
        }

        return erros;
    }

    public static List<String> validarDataDevolucao(Emprestimo emprestimo) {
        List<String> erros = new ArrayList<>();
        LocalDate dataEmprestimo = LocalDate.parse(emprestimo.getDataEmprestimo(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dataDevolucao = LocalDate.parse(emprestimo.getDataDevolucao(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (dataDevolucao.isBefore(dataEmprestimo) || dataDevolucao.isEqual(dataEmprestimo)) {
            erros.add("A data de devolução não pode ser igual ou anterior à data de empréstimo.");
        }

        return erros;
    }
}
