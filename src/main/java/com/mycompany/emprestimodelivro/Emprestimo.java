package com.mycompany.emprestimodelivro;

public class Emprestimo {

    private static int contadorEmprestimos = 0; // Contador para os empréstimos
    private int idEmprestimo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private Livro livro;
    private Leitor leitor;
    private Atendente atendente;

    //Construtor
    public Emprestimo(String dataEmprestimo, Livro livro, Leitor leitor, Atendente atendente) {
        contadorEmprestimos++;
        this.idEmprestimo = contadorEmprestimos;
        this.dataEmprestimo = dataEmprestimo;
        this.livro = livro;
        this.leitor = leitor;
        this.atendente = atendente;
    }

    public String registrarEmprestimo() {
        return "Empréstimo registrado: ID " + idEmprestimo;
    }

    public void devolverLivro(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;

    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", dataEmprestimo='" + dataEmprestimo + '\'' +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", livro=" + livro +
                ", leitor=" + leitor +
                ", atendente=" + atendente +
                '}';
    }

}
