/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojects.tarea5c;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Casa
 */
public class Curso {
    private String nombre;
    private int numHoras;
//    private Set<Alumno> alumnosMatriculados;

    public Curso(String nombre, int numHoras) {
        this.nombre = nombre;
        this.numHoras = numHoras;
//        this.alumnosMatriculados = new HashSet<>();
    }

    public Curso() {
//        this.alumnosMatriculados = new HashSet<>();
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }
//
//    public Set<Alumno> getAlumnosMatriculados() {
//        return alumnosMatriculados;
//    }
//
//    
//    public void matricularAlumno(Alumno a){
//        alumnosMatriculados.add(a);
//    }
//    
//       public void desmatricularAlumno(Alumno a){
//        alumnosMatriculados.remove(a);
//    }
    
       
    
}
