package org.example;

import java.time.*;
import java.util.*;

public class Biblioteca {

    private static CatalogoLibros gestionLibros;
    private static Prestamo gestionPrestamos;
    private static GestionUsuarios gestionUsuarios;

    public Biblioteca() {
        gestionLibros = new CatalogoLibros();
        gestionPrestamos = new Prestamo();
        gestionUsuarios = new GestionUsuarios();
    }

    public void mostrarCatalogo() {
        gestionLibros.mostrarCatalogo();
    }

    public void buscarPorTitulo(String titulo) {
        gestionLibros.buscarPorTitulo(titulo);
    }

    public void buscarPorAutor(String autor) {
        gestionLibros.buscarPorAutor(autor);
    }


    public void agregarLibro(Libro libro) {
        gestionLibros.agregarLibro(libro);
    }

    public void borrarLibro(Libro libro) {
        gestionLibros.borrarLibro(libro);
    }

    public static Prestamo prestarLibro(int idPrestamo, Libro libro, Usuario usuario, Date fechaPrestamo, boolean devuelto) {
        gestionPrestamos.prestarLibro(idPrestamo, libro, usuario, fechaPrestamo, devuelto);
        Prestamo prestamo = new Prestamo(idPrestamo, libro, usuario, fechaPrestamo, devuelto, null);
        return prestamo;
    }

    public static void devolverLibro(Prestamo prestamo, LocalDate fechaDevolucion) {
        gestionPrestamos.devolverLibro(prestamo, fechaDevolucion);
    }

    public void mostrarLibrosPorUsuario(Usuario usuario) {
        gestionPrestamos.mostrarLibrosPorUsuario(usuario);
    }

    public static int calcularDiasDeRetraso(Prestamo prestamo, LocalDate fechaDevolucion) {
        return gestionPrestamos.CalcularDiasDeRetraso(prestamo.getFechaPrestamo(), fechaDevolucion);
    }

}
