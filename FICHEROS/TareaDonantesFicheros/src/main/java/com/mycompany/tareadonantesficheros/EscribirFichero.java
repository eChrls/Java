/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareadonantesficheros;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nuria
 */
public class EscribirFichero {
    
  
    public static void escribirNombres(String ruta, Set<String> nombres) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ruta))) {
            for (String nombre : nombres) {
                writer.write(nombre);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo");
        }
    }
  public static void escribirJson(String ruta, List<Donante> donantes) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            //el writer with default... no es necesario pero si no el json queda to feo xd, pero vaya que lo puedes quitar si quieres
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(ruta), donantes);
        } catch (IOException e) {
              System.out.println("Error escribiendo");
        }
    }
}
