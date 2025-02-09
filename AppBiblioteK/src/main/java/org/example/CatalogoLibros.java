package org.example;

import java.util.*;

public class CatalogoLibros {

    ArrayList<Libro> catalogo = new ArrayList<Libro>();

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public void borrarLibro(Libro libro) {
        catalogo.remove(libro);
    }

    public boolean buscarLibro(Libro libro) {
        return catalogo.contains(libro);
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorAutor(String autor) {
        for (Libro libro : catalogo) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        return null;
    }


    public void mostrarCatalogo() {
        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }


}
