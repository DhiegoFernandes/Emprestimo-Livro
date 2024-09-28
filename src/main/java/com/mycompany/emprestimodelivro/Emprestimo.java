package com.mycompany.emprestimodelivro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {

    private static int contadorEmprestimos = 0; // Contador para os empréstimos
    private int idEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Leitor leitor;
    private Atendente atendente;

    //Construtor
    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Leitor leitor, Atendente atendente) {
        contadorEmprestimos++;
        this.idEmprestimo = contadorEmprestimos;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(10);
        this.livro = livro;
        this.leitor = leitor;
        this.atendente = atendente;
    }

    public String registrarEmprestimo() {
        livro.setDisponibilidade(LivroEnum.INDISPONIVEL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Empréstimo registrado: ID " + idEmprestimo
                + ", Data de Empréstimo: " + dataEmprestimo.format(formatter)
                + ", Data para Devolução: " + dataDevolucao.format(formatter)
                + ", Leitor: " + leitor.getNome();
    }

    public String devolverLivro(LocalDate dataDevolvido) {
        livro.setDisponibilidade(LivroEnum.DISPONIVEL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Devolução registrada: ID " + idEmprestimo
                + ", Data de Empréstimo: " + dataEmprestimo.format(formatter)
                + ", Data de Devolução: " + dataDevolvido.format(formatter)
                + ", Leitor: " + leitor.getNome();
    }

    public static int getContadorEmprestimos() {
        return contadorEmprestimos;
    }

    public static void setContadorEmprestimos(int contadorEmprestimos) {
        Emprestimo.contadorEmprestimos = contadorEmprestimos;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "idEmprestimo=" + idEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", livro=" + livro + ", leitor=" + leitor + ", atendente=" + atendente + '}';
    }

}
