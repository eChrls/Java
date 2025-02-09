package org.example;

public class Libro {
    String ISBN;
    String titulo;
    String autor;
    boolean prestado;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado(boolean b) {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }


    public Libro(String ISBN, String titulo, String autor, boolean prestado) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = prestado;
    }
}
