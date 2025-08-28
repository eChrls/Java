/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
// Conjunto para almacenar alumnos únicos (sin repetidos)

    private Set<Alumno> alumnos;

    // Conjunto para almacenar cursos únicos (sin repetidos)
    private Set<Curso> cursos;

    // Mapa que asocia cada NIF de alumno con el conjunto de cursos en los que está matriculado
    // La clave es el NIF del alumno y el valor es un conjunto de cursos
    private Map<String, Set<Curso>> matriculasAlumno;

    // Mapa que asocia cada nombre de curso con el conjunto de alumnos matriculados
    // La clave es el nombre del curso y el valor es un conjunto de alumnos
    private Map<String, Set<Alumno>> alumnosPorCurso;

    // Constructor que inicializa todas las estructuras de datos
    public GestorMatricula() {
        this.alumnos = new HashSet<>();
        this.cursos = new HashSet<>();
        this.matriculasAlumno = new HashMap<>();
        this.alumnosPorCurso = new HashMap<>();
    }

    // Método para añadir un alumno a la estructura
    // Si ya existe (mismo NIF), no se añadirá de nuevo
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        // Inicializamos su conjunto de cursos vacío si no existe ya
        // Esto evita tener que comprobar si existe la clave cada vez que matriculamos
        if (!matriculasAlumno.containsKey(alumno.getNif())) {
            matriculasAlumno.put(alumno.getNif(), new HashSet<>());
        }
    }

    // Método para añadir un curso a la estructura
    // Si ya existe (mismo nombre), no se añadirá de nuevo
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        // Inicializamos su conjunto de alumnos vacío si no existe ya
        if (!alumnosPorCurso.containsKey(curso.getNombre())) {
            alumnosPorCurso.put(curso.getNombre(), new HashSet<>());
        }
    }

    // Método para matricular un alumno en un curso
    // Actualizamos ambas estructuras de datos: matriculasAlumno y alumnosPorCurso
    public void matricular(String nifAlumno, String nombreCurso) {
        // Buscamos el alumno por su NIF
        Alumno alumnoEncontrado = null;
        for (Alumno a : alumnos) {
            if (a.getNif().equals(nifAlumno)) {
                alumnoEncontrado = a;
                break;
            }
        }

        // Buscamos el curso por su nombre
        Curso cursoEncontrado = null;
        for (Curso c : cursos) {
            if (c.getNombre().equals(nombreCurso)) {
                cursoEncontrado = c;
                break;
            }
        }

        // Verificamos que existan tanto el alumno como el curso
        if (alumnoEncontrado != null && cursoEncontrado != null) {
            // Añadimos el curso a la lista de cursos del alumno
            matriculasAlumno.get(nifAlumno).add(cursoEncontrado);

            // Añadimos el alumno a la lista de alumnos del curso
            alumnosPorCurso.get(nombreCurso).add(alumnoEncontrado);
        }
    }

    // Método para desmatricular un alumno de un curso
    // También actualizamos ambas estructuras de datos
    public void desmatricular(String nifAlumno, String nombreCurso) {
        // Buscamos el alumno y el curso igual que en matricular
        Alumno alumnoEncontrado = null;
        for (Alumno a : alumnos) {
            if (a.getNif().equals(nifAlumno)) {
                alumnoEncontrado = a;
                break;
            }
        }

        Curso cursoEncontrado = null;
        for (Curso c : cursos) {
            if (c.getNombre().equals(nombreCurso)) {
                cursoEncontrado = c;
                break;
            }
        }

        // Verificamos que existan tanto el alumno como el curso
        if (alumnoEncontrado != null && cursoEncontrado != null) {
            // Quitamos el curso de la lista de cursos del alumno
            matriculasAlumno.get(nifAlumno).remove(cursoEncontrado);

            // Quitamos el alumno de la lista de alumnos del curso
            alumnosPorCurso.get(nombreCurso).remove(alumnoEncontrado);
        }
    }

    // Método para calcular e imprimir el total de horas que cursa cada alumno
    // Ordenamos por NIF como pide el enunciado
    public void imprimirHorasPorAlumno() {
        // Creamos un mapa para almacenar las horas por alumno
        Map<String, Integer> horasPorAlumno = new HashMap<>();

        // Recorremos cada alumno
        for (Alumno alumno : alumnos) {
            String nif = alumno.getNif();
            int totalHoras = 0;

            // Para cada alumno, sumamos las horas de todos sus cursos
            Set<Curso> cursosDelAlumno = matriculasAlumno.get(nif);
            if (cursosDelAlumno != null) {
                for (Curso curso : cursosDelAlumno) {
                    totalHoras += curso.getHoras();
                }
            }

            // Guardamos el total de horas del alumno
            horasPorAlumno.put(nif, totalHoras);
        }

        // Convertimos el mapa a una lista para poder ordenarla
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(horasPorAlumno.entrySet());

        // Ordenamos la lista por NIF (alfabéticamente)
        // Usamos un comparador que ordena las entradas del mapa por su clave (NIF)
        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // Comparamos las claves (NIFs) usando el método compareTo de String
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        // Imprimimos los resultados en el formato especificado
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            System.out.println("NIF: " + entry.getKey() + " ---> Nº HORAS: " + entry.getValue());
        }
    }

    // Métodos para obtener información sobre los alumnos y cursos
    // Devuelve los cursos en los que está matriculado un alumno dado su NIF
    public Set<Curso> getCursosDeAlumno(String nif) {
        return matriculasAlumno.getOrDefault(nif, new HashSet<>());
    }

    // Devuelve los alumnos matriculados en un curso dado su nombre
    public Set<Alumno> getAlumnosDeCurso(String nombreCurso) {
        return alumnosPorCurso.getOrDefault(nombreCurso, new HashSet<>());
    }

    // Getters para obtener las colecciones completas
    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }
}
