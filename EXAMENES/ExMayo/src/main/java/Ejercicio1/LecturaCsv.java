/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author carlos
 */
public class LecturaCsv {

    /*
Crea una clase llamada LecturaCSV, que reciba la ruta del fichero a leer y devuelva una lista de objetos
    que contengan la información de cada registro del fichero. 
    Hay que prestar especial atención a los distintos tipos de datos a utilizar.*/
    // Lee un CSV y crea una lista de objetos Curso con separador ;
//    public static List<Curso> leerCsv(String ruta) throws IOException {
//
//        //String fechaFormateada = fechaHoy.format(formatter);
//        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
//            // Formateo de la fecha
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            return br.lines().map(l -> {
//                String[] datos = l.split(";");
//                return new Curso(
//                        datos[0].trim().replaceAll("\"", ""),
//                        datos[1].trim().replaceAll("\"", ""),
//                        datos[2].trim().replaceAll("\"", ""),
//                        datos[3].trim().replaceAll("\"", ""),
//                        datos[4].trim().replaceAll("\"", ""),
//                        LocalDate.parse(datos[5], formatter),
//                        LocalDate.parse(datos[6], formatter),
//                        datos[7].trim()
//                );
//            }).collect(Collectors.toList());
//        }
//    }

    public static List<Curso> leerCsv2() throws IOException {
        String ruta = "./cursosCEP.csv";
        String separador = ";";
        List<Curso> cursos = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(separador);

                //Primero limpio todos los campos en un bucle for
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim();
                    if (datos[i].startsWith("\"") && datos[i].endsWith("\"")) {
                        datos[i] = datos[i].substring(1, datos[i].length() - 1);
                        datos[i] = datos[i].trim();

                    }
                }
                //DESPUÉS de ese bucle (no dentro), creo UN SOLO objeto Horario por línea
                if (datos.length >= 8) {
                    try {
                        // Formateo de la fecha
                     //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
                        Curso curso = new Curso(
                                datos[0].trim().replaceAll("\"", ""),
                                datos[1].trim().replaceAll("\"", ""),
                                datos[2].trim().replaceAll("\"", ""),
                                datos[3].trim().replaceAll("\"", ""),
                                datos[4].trim().replaceAll("\"", ""),
                                datos[4].trim().replaceAll("\"", ""),
                                datos[6].trim().replaceAll("\"", ""),
                             //   LocalDate.parse(datos[5], formatter),
                            //    LocalDate.parse(datos[6], formatter),
                                datos[7].trim()
                        );
                        cursos.add(curso);

                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir a numero la linea " + line);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error en el catch");
        }

        return cursos;
    }
}
