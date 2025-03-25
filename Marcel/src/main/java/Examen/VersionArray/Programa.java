/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen.VersionArray;

import java.util.Random;

public class Programa {

    public static void main(String[] args) {
        // "Genera una lista con todas las fichas del juego, invocando el método generarTodas()."
        Ficha[] fichas = OperacionesRummi.generarTodas();

        // "Usando un iterador, recorre la lista y muestra por pantalla el contenido."
        for (Ficha ficha : fichas) {
            System.out.println(ficha);
        }

        // "Baraja la lista anterior, usa 1000 movimientos. Muestra el contenido usando un foreach y una expresión lambda."
        OperacionesRummi.barajarFichas(1000, fichas);
        for (Ficha ficha : fichas) {
            System.out.println(ficha);
        }

        // "Saca 30 fichas, guardando el resultado en una nueva lista. Muestra el contenido de la nueva lista de 30 fichas, así como su tamaño. Muestra el contenido de la lista original, así como su tamaño."
        Ficha[] fichasSacadas = OperacionesRummi.sacarFichas(30, fichas);
        System.out.println("Fichas sacadas:");
        for (Ficha ficha : fichasSacadas) {
            System.out.println(ficha);
        }
        System.out.println("Tamaño de fichas sacadas: " + fichasSacadas.length);
        System.out.println("Fichas restantes:");
        for (Ficha ficha : fichas) {
            if (ficha != null) {
                System.out.println(ficha);
            }
        }
        System.out.println("Tamaño de fichas restantes: " + contarFichasRestantes(fichas));

        // "Comprueba si existe un trío, mostrando el resultado por pantalla."
        int[] trio = existeTrio(fichasSacadas);
        System.out.println("Trío encontrado en posiciones: " + (trio == null ? "null" : trio[0] + ", " + trio[1] + ", " + trio[2]));

        // "Comprueba si existe una escalera, mostrando el resultado por pantalla."
        int[] escalera = existeEscalera(fichasSacadas);
        System.out.println("Escalera encontrada en posiciones: " + (escalera == null ? "null" : escalera[0] + ", " + escalera[1] + ", " + escalera[2]));
    }

    // Método auxiliar para contar las fichas restantes en el array
    public static int contarFichasRestantes(Ficha[] fichas) {
        int count = 0;
        for (Ficha ficha : fichas) {
            if (ficha != null) {
                count++;
            }
        }
        return count;
    }

    // Método para comprobar si existe un trío
    public static int[] existeTrio(Ficha[] lista) {
        if (lista == null || lista.length < 3) {
            return null;
        }

        for (int i = 0; i < lista.length - 2; i++) {
            for (int j = i + 1; j < lista.length - 1; j++) {
                for (int k = j + 1; k < lista.length; k++) {
                    if (lista[i] != null && lista[j] != null && lista[k] != null &&
                            lista[i].getNumero() == lista[j].getNumero() &&
                            lista[i].getNumero() == lista[k].getNumero() &&
                            lista[i].getColor() != lista[j].getColor() &&
                            lista[i].getColor() != lista[k].getColor() &&
                            lista[j].getColor() != lista[k].getColor()) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return null;
    }

    // Método para comprobar si existe una escalera
    public static int[] existeEscalera(Ficha[] lista) {
        if (lista == null || lista.length < 3) {
            return null;
        }

        for (int i = 0; i < lista.length - 2; i++) {
            for (int j = i + 1; j < lista.length - 1; j++) {
                for (int k = j + 1; k < lista.length; k++) {
                    if (lista[i] != null && lista[j] != null && lista[k] != null &&
                            lista[i].getColor() == lista[j].getColor() &&
                            lista[i].getColor() == lista[k].getColor()) {
                        int[] numeros = {lista[i].getNumero(), lista[j].getNumero(), lista[k].getNumero()};
                        java.util.Arrays.sort(numeros);

                        if (numeros[1] == numeros[0] + 1 && numeros[2] == numeros[1] + 1) {
                            return new int[]{i, j, k};
                        }
                    }
                }
            }
        }
        return null;
    }
}