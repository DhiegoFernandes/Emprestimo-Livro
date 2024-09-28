package com.mycompany.emprestimodelivro;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestValidation {
    
    //TODO SETAR A SAÌDA CORRETA ESPERADA COM ASSERT
    @Test
    public void idLivroInvalido_DeveRetornarErro() {
        Livro livro = new Livro(-1, "O Hobbit", LivroEnum.DISPONIVEL);
        List<String> erros = LivroTest.ehValidoParaInclusao(livro);
        assertTrue(erros.contains("O ID do livro não pode ser menor que 0."));
    }

    @Test
    public void idEmprestimoInvalido_DeveRetornarErro() {
         Emprestimo emprestimo = new Emprestimo(new Livro(1, "O Hobbit", LivroEnum.DISPONIVEL), new Leitor(), new Atendente());
        List<String> erros = EmprestimoTest.ehValidoParaInclusao(emprestimo);
        assertTrue(erros.contains("O ID do empréstimo não pode ser menor que 0."));
    }

    @Test
    public void dataEmprestimoInvalida_DeveRetornarErro() {
        Emprestimo emprestimo = new Emprestimo(new Livro(1, "O Hobbit", LivroEnum.DISPONIVEL), new Leitor(), new Atendente());
        List<String> erros = EmprestimoTest.validarDataEmprestimo(emprestimo);
        assertTrue(erros.contains("A data de empréstimo não pode ser anterior à data atual."));
    }

    @Test
    public void dataDevolucaoInvalida_DeveRetornarErro() {
         Emprestimo emprestimo = new Emprestimo(new Livro(1, "O Hobbit", LivroEnum.DISPONIVEL), new Leitor(), new Atendente());
        emprestimo.setDataDevolucao(LocalDate.now().minusDays(1)); // Data de devolução anterior à data de empréstimo
        List<String> erros = EmprestimoTest.validarDataDevolucao(emprestimo);
        assertTrue(erros.contains("A data de devolução não pode ser igual ou anterior à data de empréstimo."));
    }

    @Test
    public void numeroLivrosEmprestadosInvalido_DeveRetornarErro() {
        int numeroLivrosEmprestados = -1;
        int numeroLivrosDisponiveis = 10;
        List<String> erros = LivroTest.validarNumeroDeLivros(numeroLivrosEmprestados, numeroLivrosDisponiveis);
        assertTrue(erros.contains("O número de livros emprestados não pode ser menor que 0."));
    }

    @Test
    public void numeroLivrosEmprestadosMaiorQueDisponivel_DeveRetornarErro() {
        int numeroLivrosEmprestados = 10;
        int numeroLivrosDisponiveis = 10;
        List<String> erros = LivroTest.validarNumeroDeLivros(numeroLivrosEmprestados, numeroLivrosDisponiveis);
        assertTrue(erros.contains("O número de livros emprestados não pode ser maior ou igual ao número de livros disponíveis."));
    }

    @Test
    public void idAtendenteInvalido_MenorQueZero_DeveRetornarErro() {
        Atendente atendente = new Atendente(-1, "João Silva");
        List<String> erros = AtendenteTest.ehValidoParaInclusao(atendente);
        assertTrue(erros.contains("O ID do atendente não pode ser menor que 0."));
    }

    @Test
    public void idLeitorInvalido_MenorQueZero_DeveRetornarErro() {
        Leitor leitor = new Leitor(-1, "Maria Oliveira", 0);
        List<String> erros = LeitorTest.ehValidoParaInclusao(leitor);
        assertTrue(erros.contains("O ID do leitor não pode ser menor que 0."));
    }

    @Test
    public void nomeLeitorInvalido_ContemNumeros_DeveRetornarErro() {
        Leitor leitor = new Leitor(1, "Maria123 Oliveira", 0);
        List<String> erros = LeitorTest.ehValidoParaInclusao(leitor);
        assertTrue(erros.contains("O nome do leitor deve conter apenas letras."));
    }

    @Test
    public void tituloLivroInvalido_Vazio_DeveRetornarErro() {
        Livro livro = new Livro(1, "", LivroEnum.DISPONIVEL);
        List<String> erros = LivroTest.ehValidoParaInclusao(livro);
        assertTrue(erros.contains("O título do livro não pode ser vazio."));
    }

    @Test
    public void nomeLeitorInvalido_Vazio_DeveRetornarErro() {
        Leitor leitor = new Leitor(1, "", 0);
        List<String> erros = LeitorTest.ehValidoParaInclusao(leitor);
        assertTrue(erros.contains("O nome do leitor não pode ser vazio."));
    }

    @Test
    public void emprestimoComAtendenteNulo_DeveRetornarErro() {
       Emprestimo emprestimo = new Emprestimo(new Livro(1, "O Hobbit", LivroEnum.DISPONIVEL), new Leitor(), new Atendente());
        List<String> erros = EmprestimoTest.ehValidoParaInclusao(emprestimo);
        assertTrue(erros.contains("O atendente não pode ser nulo."));
    }
}