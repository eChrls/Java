/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Bingo {

    public static void main(String[] args) throws IOException {
        // Leer el fichero JSON y cargar en lista de objetos
        List<Carton> listaCarton = leerJson("./cartonbingo.json");

        // Obtener matriz de enteros (3x9)
        int[][] matriz = construirMatriz(listaCarton);

        // Imprimir matriz por consola
        imprimirMatriz(matriz);

        // Generar 150 números aleatorios entre 1 y 90
        List<Integer> numeros = generarNumerosAleatorios(150, 1, 90);

        // Verificar si se puede cantar línea
        int filaLinea = verificarLinea(matriz, numeros);
        System.out.println("Fila con línea: " + filaLinea);
    }

    // Leer el fichero JSON
    public static List<Carton> leerJson(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Carton>>() {});
    }

    // Convertir la lista en una matriz de enteros 3x9
    public static int[][] construirMatriz(List<Carton> lista) {
        int[][] matriz = new int[3][9];
        for (Carton c : lista) {
            matriz[c.getFila() - 1][c.getColumna() - 1] = c.getValor();
        }
        return matriz;
    }

    // Imprimir la matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor == 0) {
                    System.out.print("   \t");
                } else {
                    System.out.print(valor + "\t");
                }
            }
            System.out.println();
        }
    }

    // Generar lista de enteros aleatorios entre min y max
    public static List<Integer> generarNumerosAleatorios(int cantidad, int min, int max) {
        Random rand = new Random();
        List<Integer> numeros = new ArrayList<>();
        while (numeros.size() < cantidad) {
            int n = rand.nextInt(max - min + 1) + min;
            if (!numeros.contains(n)) {
                numeros.add(n);
            }
        }
        return numeros;
    }

    // Verificar si hay una línea completa (todos los valores no cero están en la lista de números)
    public static int verificarLinea(int[][] matriz, List<Integer> numerosCantados) {
        Set<Integer> numerosSet = new HashSet<>(numerosCantados);
        for (int i = 0; i < 3; i++) {
            boolean linea = true;
            for (int valor : matriz[i]) {
                if (valor != 0 && !numerosSet.contains(valor)) {
                    linea = false;
                    break;
                }
            }
            if (linea) {
                return i + 1; // Fila encontrada (1, 2 o 3)
            }
        }
        return -1; // No se puede cantar línea
    }
}

//public class Bingo {
//    public static void main(String[] args) throws IOException {
//        List<Carton> cartones = new ArrayList<>();
//        cartones = leerJson();                  
//    }   
//          public static List<Carton> leerJson() throws IOException {
//        String ruta="./cartonbingo.json";
//         ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(new File(ruta), new TypeReference<List<Carton>>() {});
//     
//         public static Carton[][] obtenerCartones(List<Carton> cartones) {
//        Carton[][] ct = new Carton[3][9];        
//            Carton[ct.getFila][ct.getColumna];
//                });
//        return matriz;
//    }
//}
//        public static void mostrarMatriz(Horario[][] th) {
//        for (int i = 0; i < dias.length; i++) {
//            System.out.print(dias[i] + "\t");
//        }
//        System.out.println();
//        for (int hora = 0; hora < th[0].length; hora++) {
//            for (int dia = 0; dia < th.length; dia++) {
//                if (th[dia][hora] != null) {
//                    System.out.print(th[dia][hora].getAsignatura() + "\t");
//                } else {
//                    System.out.print("   \t");
//                }
//            }
//            System.out.println();
//        }
//    }
//}
