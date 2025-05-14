/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.time.LocalDate;


public class Curso {
    //Crear objeto plantilla para el csv con constructor por defecto y getters
    private String codigo; 
    private String centro;
    private String titulo;
    private String modalidad;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String dirigidoA;

    public Curso() {
    }

    public Curso(String codigo, String centro, String titulo, String modalidad, String estado, LocalDate fechaInicio, LocalDate fechaFin, String dirigidoA) {
        this.codigo = codigo;
        this.centro = centro;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dirigidoA = dirigidoA;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(String dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", centro=" + centro + ", titulo=" + titulo + ", modalidad=" + modalidad + ", estado=" + estado + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", dirigidoA=" + dirigidoA + '}';
    }

 
   
    
    
    
    
    
    
    
    }


   