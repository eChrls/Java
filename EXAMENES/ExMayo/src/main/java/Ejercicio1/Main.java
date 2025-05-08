/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Main {
    
    public static void main(String[] args) throws IOException {
        /*Hay que crear una lista de cursos y descargar la lectura en el
        Luego hay que ordenador por campo de fecha de inicio esa lista y luego por titulo con comparator
        Luego hacer un Set de modalidad = Jornadas, teniendo cuidado de mayusculas y minusculas,
        y con fecha de fin anterior a 2020-01-01. Y por ultimo imprimir con iterator
        Luego un Map con un count de numero de cursos (terminados?) por cada centro. 
        Por ultimo un count distinct de todas las modalidades que hay
        */
        List<Curso>cursos = new ArrayList<>();
        
        cursos = LecturaCsv.leerCsv2();
          

        
        
        Set<String>cursoSet = new TreeSet<>();
        cursoSet = filtrarModalidad(cursos, "Jornadas");
     
        
     /**
     * Imprime por pantalla un SET usando un objeto de tipo iterator.
     */
        Iterator<String> iterator = cursoSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
     
//        cursos.forEach(System.out::println);

//  Contar el número de modalidades distintas que hay.
    List<String> modalidadesDistintas  =cursos.stream()
                                .map(Curso::getModalidad)
                                .distinct()
                                .collect(Collectors.toList());
            

    
                        
                        
                        
    //fin main
    }
    
      
         //   Mostrar la lista completa, ordenada por el campo fecha de inicio y en caso de que haya fechas iguales, 
    //entonces los objetos también aparecerán ordenados por título.
    
    public static Comparator<Curso> ordenarFechaYtitulo() {
        return Comparator.comparing(Curso::getFechaInicio)
                .thenComparing(Curso::getTitulo);
    }

    
    //Obtener un conjunto único de nombres de cursos cuya modalidad es "Jornadas" 
    //y su fecha de fin sea anterior a 01/01/2020. Usa un objeto iterator para imprimir por pantalla el contenido.
   // hacer un Set de modalidad = Jornadas, teniendo cuidado de mayusculas y minusculas,
      public static Set<String> filtrarModalidad(List<Curso> cursos, String modalidad) {
          
        return cursos.stream()
                 .map(Curso::getModalidad)
                .filter(m -> m.equalsIgnoreCase(modalidad))
               .collect(Collectors.toSet());
    }
      
     
//Obtener en un map el número total de cursos terminados de cada centro de profesorado.
 
       public static Map<String, Integer> cursosTerminadosProfesor(List<Curso> lista, LocalDate fechaFin, String nombre) {
        return lista.stream()
                .collect(Collectors.toMap(Curso::getCentro, Curso::getFechaFin));
    }




}
