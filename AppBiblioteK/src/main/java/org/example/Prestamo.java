package org.example;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class Prestamo {
    int idPrestamo;
    Libro libro;
    Usuario usuario;
    LocalDate fechaPrestamo;
    LocalDate fechaDevolucion;
    boolean devuelto;
    int diasPrestamo = 14;

    public Prestamo() {

    }


    public boolean prestarLibro(int idPrestamo, Libro libro, Usuario usuario, LocalDate fechaPrestamo, boolean devuelto) {
        if (usuario.getLibrosPrestados() < 3) {
            this.libro = libro;
            libro.isPrestado(true);
            this.usuario = usuario;
            usuario.addLibrosPrestados();
            this.fechaPrestamo = fechaPrestamo;
            this.devuelto = false;
            return true;
        }
        return false;
    }

    public int CalcularDiasDeRetraso(Prestamo prestamo, LocalDate fechaDevolucion) {

        LocalDate hoy = LocalDate.now();
        long diff = ChronoUnit.DAYS.between(fechaPrestamo, hoy);
        return (int) diff;




    public void devolverLibro(Prestamo prestamo) {
        libro.isPrestado(false);
        prestamo.devuelto = true;
        usuario.removeLibrosPrestados();
        this.fechaDevolucion = prestamo.setFechaDevolucion(LocalDate.now());
    }


    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public boolean isDevuelto() {
        if (devuelto) {
            return true;
        }
        return false;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalDate fechaDevolucion() {
        if (devuelto) {
            return fechaDevolucion;
            LocalDate hoy = LocalDate.now();
            return hoy;
        }
        return null;
    }

    public void mostrarLibrosPorUsuario(Usuario usuario) {
        List<Prestamo> prestamos = new ArrayList<>();
        // Obtener los préstamos del usuario de la base de datos
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().getDni().equals(usuario.getDni())) {
                System.out.println(prestamo);
            }
        }
    }

    public Prestamo(int idPrestamo, Libro libro, Usuario usuario, LocalDate fechaPrestamo, boolean devuelto, LocalDate fechaDevolucion) {

        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = devuelto;
        this.fechaDevolucion = fechaDevolucion;

    }

}

        private LocalDate setFechaDevolucion(LocalDate now) {
        LocalDate hoy = LocalDate.now();
        return hoy;
        }
    }
