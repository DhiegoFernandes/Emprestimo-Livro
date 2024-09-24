
package com.mycompany.emprestimodelivro;

public class Livro {
    
    private int idLivro;
    private String titulo;
    private String disponibilidade;

    public Livro(int idLivro, String titulo, String disponibilidade) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.disponibilidade = disponibilidade;
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


    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Livro{" + "idLivro=" + idLivro + ", titulo=" + titulo + ", disponibilidade=" + disponibilidade + '}';
    }
    
    
    
}
