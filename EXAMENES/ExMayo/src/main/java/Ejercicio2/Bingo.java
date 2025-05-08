/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import Examen_final.Futbolista;
import bingo.Carton;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tarea7f.Horario;

/**
 *
 * @author carlos
 */
public class Bingo {
    public static void main(String[] args) throws IOException {
        
        List<Carton> cartones = new ArrayList<>();
        cartones = leerJson();
        
        
                
    }
    
          public static List<Carton> leerJson() throws IOException {
        String ruta="./cartonbingo.json";
         ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Carton>>() {});
        
         public static Carton[][] obtenerCartones(List<Carton> cartones) {

        Carton[][] ct = new Carton[3][9];
        
            Carton[ct.getFila][ct.getColumna];
                });

        return matriz;
    }

          
}
  
    

        public static void mostrarMatriz(Horario[][] th) {


        for (int i = 0; i < dias.length; i++) {
            System.out.print(dias[i] + "\t");
        }
        System.out.println();

        for (int hora = 0; hora < th[0].length; hora++) {
            for (int dia = 0; dia < th.length; dia++) {

                if (th[dia][hora] != null) {
                    System.out.print(th[dia][hora].getAsignatura() + "\t");
                } else {
                    System.out.print("   \t");
                }
            }
            System.out.println();
        }
    }
    
    
    
    
    
    
}
