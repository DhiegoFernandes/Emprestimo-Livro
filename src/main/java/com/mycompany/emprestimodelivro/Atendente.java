package com.mycompany.emprestimodelivro;

public class Atendente {

    private int idAtendente;
    private String nome;

    public Atendente(){}

    public Atendente(int idAtendente, String nome) {
        this.idAtendente = idAtendente;
        this.nome = nome;
    }
    
    public boolean validarIdentificacaoLeitor(Leitor leitor) {
        if (leitor.getIdCarteiraDeIdentificacao() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Atendente{" + "idAtendente=" + idAtendente + ", nome=" + nome + '}';
    }
    
    
    
}
