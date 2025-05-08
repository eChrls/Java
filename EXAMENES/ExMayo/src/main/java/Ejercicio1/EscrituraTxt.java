/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author carlos
 */
public class EscrituraTxt {
    /*Crea una clase, llamada EscrituraTXT que reciba el nombre del fichero a generar y una lista de cursos 
    y genere un fichero de texto en la raíz del proyecto, pero sólo con aquellos cursos suspendidos. 
    Los campos de cada registro de este fichero serán: código, título del curso y modalidad, separados por carácter (;).*/
        // Lee un fichero de texto y elimina caracteres separadores como ; o *

        // Escribe una lista de objetos Futbolista en un fichero CSV
    public static void escribirTxt(List<Curso> cursos) throws IOException {
         String ruta ="./cursos.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
              bw.write("Centro" + ";"+"Codigo" + ";"+"Titulo" + ";"+"Modalidad" + ";"+"Estado" + ";"+"Fecha inicio" + ";"+"Fecha Fin" + ";"+"Dirigido a");
               bw.newLine();
            for (Curso c : cursos) {
                bw.write(c.getCodigo()+ ";" + c.getCentro()+ ";" + c.getTitulo() + ";"
                        + c.getModalidad()+ ";" + c.getEstado() + ";" + c.getFechaInicio()+ ";" + c.getFechaFin() + ";" +c.getDirigidoA());
                bw.newLine();
            }
        }
    }

    
    
}
