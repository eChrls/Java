/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author carlos
 */
public class GestorMatricula {
    
    private List<Alumno>alumnos;
    private List<Curso>cursos; 
    private Map<String, Set<Alumno>>  mapAlums;
    private Map<String, Set<Curso>>  mapCurso;
    
    //Conocer que alumnos estan en un curso concreto
        public static <Curso, curso> List<Alumno> mapearAlumnos(List<Curso> cursos, Function<Curso, Alumno> transformador) {
        return cursos.stream().map(transformador).collect(Collectors.toList());
    }
   
//Conocer que cursos tiene un alumno
            public static <Alumno, alumnos> List<Curso> mapearCursos(List<Alumno> alumnos, Function<Alumno, Curso> transformador) {
        return alumnos.stream().map(transformador).collect(Collectors.toList());
    }
    
            
            
            
            
            
            
            
}
