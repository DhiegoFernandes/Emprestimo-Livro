package com.mycompany.emprestimodelivro;

import org.junit.jupiter.api.Test;
import com.mycompany.emprestimodelivro.Livro;
import com.mycompany.emprestimodelivro.LivroEnum;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestValidation {

    @Test
    public void idLivroInvalido_DeveRetornarErro() {
        Livro livro = new Livro(-1, "O Hobbit", LivroEnum.DISPONIVEL);
        List<String> erros = LivroClassTests.ehValidoParaInclusao(livro);
        assertTrue(erros.contains("O ID do livro não pode ser menor que 0."));
    }

    @Test
    public void idEmprestimoInvalido_DeveRetornarErro() {
        Emprestimo emprestimo = new Emprestimo("2023-09-01", new Livro(1, "O Hobbit", null), new Leitor(), new Atendente());
        // Forçando o ID para um valor inválido para simular a situação
        emprestimo = new Emprestimo("2023-09-01", new Livro(-1, "O Hobbit", null), new Leitor(), new Atendente());
        List<String> erros = EmprestimoClassTests.ehValidoParaInclusao(emprestimo);
        assertTrue(erros.contains("O ID do empréstimo não pode ser menor que 0."));
    }

    @Test
    public void dataEmprestimoInvalida_DeveRetornarErro() {
        Emprestimo emprestimo = new Emprestimo("2022-01-01", new Livro(1, "O Hobbit", null), new Leitor(), new Atendente());
        List<String> erros = EmprestimoClassTests.validarDataEmprestimo(emprestimo);
        assertTrue(erros.contains("A data de empréstimo não pode ser anterior à data atual."));
    }

    @Test
    public void dataDevolucaoInvalida_DeveRetornarErro() {
        Emprestimo emprestimo = new Emprestimo("2023-09-20", new Livro(1, "O Hobbit", null), new Leitor(), new Atendente());
        emprestimo.devolverLivro("2023-09-19"); // Data de devolução anterior à data de empréstimo
        List<String> erros = EmprestimoClassTests.validarDataDevolucao(emprestimo);
        assertTrue(erros.contains("A data de devolução não pode ser igual ou anterior à data de empréstimo."));
    }

    @Test
    public void numeroLivrosEmprestadosInvalido_DeveRetornarErro() {
        int numeroLivrosEmprestados = -1;
        int numeroLivrosDisponiveis = 10;
        List<String> erros = LivroClassTests.validarNumeroDeLivros(numeroLivrosEmprestados, numeroLivrosDisponiveis);
        assertTrue(erros.contains("O número de livros emprestados não pode ser menor que 0."));
    }

    @Test
    public void numeroLivrosEmprestadosMaiorQueDisponivel_DeveRetornarErro() {
        int numeroLivrosEmprestados = 10;
        int numeroLivrosDisponiveis = 10;
        List<String> erros = LivroClassTests.validarNumeroDeLivros(numeroLivrosEmprestados, numeroLivrosDisponiveis);
        assertTrue(erros.contains("O número de livros emprestados não pode ser maior ou igual ao número de livros disponíveis."));
    }

    @Test
    public void idAtendenteInvalido_MenorQueZero_DeveRetornarErro() {
        Atendente atendente = new Atendente(-1, "João Silva");
        List<String> erros = AtendenteClassTests.ehValidoParaInclusao(atendente);
        assertTrue(erros.contains("O ID do atendente não pode ser menor que 0."));
    }

    @Test
    public void idLeitorInvalido_MenorQueZero_DeveRetornarErro() {
        Leitor leitor = new Leitor(-1, "Maria Oliveira", 0);
        List<String> erros = LeitorClassTests.ehValidoParaInclusao(leitor);
        assertTrue(erros.contains("O ID do leitor não pode ser menor que 0."));
    }

    @Test
    public void nomeLeitorInvalido_ContemNumeros_DeveRetornarErro() {
        Leitor leitor = new Leitor(1, "Maria123 Oliveira", 0);
        List<String> erros = LeitorClassTests.ehValidoParaInclusao(leitor);
        assertTrue(erros.contains("O nome do leitor deve conter apenas letras."));
    }


}