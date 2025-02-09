package org.example;

import java.time.*;

public class Usuario {
    String dni;
    String nombre;
    LocalDate fechaNacimiento;
    int librosPrestados;

    public void addLibrosPrestados() {
        librosPrestados++;
    }

    public void removeLibrosPrestados() {
        librosPrestados--;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario(String dni, String nombre, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{  " +
                "dni=  " + dni +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=  " + fechaNacimiento +
                "librosPrestados=  " + librosPrestados +
                '}';
    }
}


