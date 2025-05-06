/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tarea7f;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class tarea7f {

    public static void main(String[] args) throws IOException {
        List<Horario>horarios = new ArrayList<>();
        horarios = leerCsv();
        horarios.forEach(System.out::println);
        
    }

    public static List<Horario> leerCsv() throws IOException {
        String ruta = "./";
        String separador = ";";
        List<Horario> horarios = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(separador);
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim().substring(datos[i].re,);
                    Horario horario = new Horario(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                    horarios.add(horario);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return horarios;
    }

}
