
package com.mycompany.emprestimodelivro;

public class Leitor {
    
    private int IdcarteiraDeIdentificacao;
    private String nome;
    private int livrosEmprestados;

    public Leitor(int carteiraDeIdentificacao, String nome, int livrosEmprestados) {
        this.IdcarteiraDeIdentificacao = carteiraDeIdentificacao;
        this.nome = nome;
        this.livrosEmprestados = livrosEmprestados;
    }


    public int getIdCarteiraDeIdentificacao() {
        return IdcarteiraDeIdentificacao;
    }

    public void setIdarteiraDeIdentificacao(int carteiraDeIdentificacao) {
        this.IdcarteiraDeIdentificacao = carteiraDeIdentificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(int livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    @Override
    public String toString() {
        return "Leitor{" + ", carteiraDeIdentificacao=" + IdcarteiraDeIdentificacao + ", nome=" + nome + ", livrosEmprestados=" + livrosEmprestados + '}';
    }
    
    
    
}
