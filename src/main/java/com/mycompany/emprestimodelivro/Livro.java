package com.mycompany.emprestimodelivro;

public class Livro {

    private int idLivro;
    private String titulo;
    private LivroEnum disponibilidade;

    public Livro() {
    }

    public Livro(int idLivro, String titulo, LivroEnum disponibilidade) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.disponibilidade = disponibilidade;
    }

    public String verificarDisponibilidade() {
        switch (disponibilidade) {
            case DISPONIVEL:
                return "O livro " + titulo + " está disponível.";
            case INDISPONIVEL:
                return "O livro " + titulo + " está indisponível.";
            default:
                return "Status de disponibilidade desconhecido.";
        }
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LivroEnum getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(LivroEnum disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Livro{" + "idLivro=" + idLivro + ", titulo=" + titulo + ", disponibilidade=" + disponibilidade + '}';
    }

}
