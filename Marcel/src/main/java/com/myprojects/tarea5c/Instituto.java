/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojects.tarea5c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Casa
 */
public class Instituto {
    
    Set<Alumno> listaAlumnos;
    List<Curso>listaCursos;
    Map<String, Set<Alumno>> alumnosPorCurso;
    Map<String, List<Curso>> cursosPorAlumno;
    
    

    public Instituto() {
        this.listaCursos=new ArrayList<>();
        this.listaAlumnos=new HashSet<>();
        this.alumnosPorCurso = new HashMap<>();
        this.cursosPorAlumno = new TreeMap<>();
        
    }
    
   public void matricularAlumno(Alumno a, Curso c){
       Set<Alumno> alumnos = alumnosPorCurso.get(c.getNombre());
       alumnos.add(a);
       alumnosPorCurso.put(c.getNombre(), alumnos);
       
       String nif = a.getNif();
       listaCursos.add(c);
       cursosPorAlumno.put(nif, listaCursos);
       
       
   }
    
   
}
