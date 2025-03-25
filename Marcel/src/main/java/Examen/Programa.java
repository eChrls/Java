/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Programa {

    public static void main(String[] args) {
        // 1. Generar una lista con todas las fichas del juego
        List<Ficha> fichas = OperacionesRummi.generarTodas();

        // 2. Mostrar las fichas usando un iterador
        Iterator<Ficha> iterador = fichas.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        // 3. Barajar la lista 1000 veces y mostrar el contenido usando foreach y lambda
        OperacionesRummi.barajarFichas(1000, fichas);
        fichas.forEach(System.out::println);

        // 4. Sacar 30 fichas y mostrar el contenido de ambas listas
        List<Ficha> fichasSacadas = OperacionesRummi.sacarFichas(30, fichas);
        System.out.println("Fichas sacadas: " + fichasSacadas);
        System.out.println("Tamaño de fichas sacadas: " + fichasSacadas.size());
        System.out.println("Fichas restantes: " + fichas);
        System.out.println("Tamaño de fichas restantes: " + fichas.size());

        // 5. Comprobar si existe un trío y mostrar el resultado
        List<Integer> trio = existeTrio(fichasSacadas);
        System.out.println("Trío encontrado en posiciones: " + trio);

        // 6. Comprobar si existe una escalera y mostrar el resultado
        List<Integer> escalera = existeEscalera(fichasSacadas);
        System.out.println("Escalera encontrada en posiciones: " + escalera);
    }

    // Método para comprobar si existe un trío
    public static List<Integer> existeTrio(List<Ficha> lista) {
        if (lista == null || lista.size() < 3) {
            return null;
        }

        for (int i = 0; i < lista.size() - 2; i++) {
            for (int j = i + 1; j < lista.size() - 1; j++) {
                for (int k = j + 1; k < lista.size(); k++) {
                    Ficha ficha1 = lista.get(i);
                    Ficha ficha2 = lista.get(j);
                    Ficha ficha3 = lista.get(k);

                    if (ficha1.getNumero() == ficha2.getNumero() &&
                            ficha1.getNumero() == ficha3.getNumero() &&
                            ficha1.getColor() != ficha2.getColor() &&
                            ficha1.getColor() != ficha3.getColor() &&
                            ficha2.getColor() != ficha3.getColor()) {
                        List<Integer> posicionesTrio = new ArrayList<>();
                        posicionesTrio.add(i);
                        posicionesTrio.add(j);
                        posicionesTrio.add(k);
                        return posicionesTrio;
                    }
                }
            }
        }
        return null;
    }

    // Método para comprobar si existe una escalera
    public static List<Integer> existeEscalera(List<Ficha> lista) {
        if (lista == null || lista.size() < 3) {
            return null;
        }

        for (int i = 0; i < lista.size() - 2; i++) {
            for (int j = i + 1; j < lista.size() - 1; j++) {
                for (int k = j + 1; k < lista.size(); k++) {
                    Ficha ficha1 = lista.get(i);
                    Ficha ficha2 = lista.get(j);
                    Ficha ficha3 = lista.get(k);

                    if (ficha1.getColor() == ficha2.getColor() &&
                            ficha1.getColor() == ficha3.getColor()) {
                        List<Integer> numeros = new ArrayList<>();
                        numeros.add(ficha1.getNumero());
                        numeros.add(ficha2.getNumero());
                        numeros.add(ficha3.getNumero());
                        Collections.sort(numeros);

                        if (numeros.get(1) == numeros.get(0) + 1 &&
                                numeros.get(2) == numeros.get(1) + 1) {
                            List<Integer> posicionesEscalera = new ArrayList<>();
                            posicionesEscalera.add(i);
                            posicionesEscalera.add(j);
                            posicionesEscalera.add(k);
                            return posicionesEscalera;
                        }
                    }
                }
            }
        }
        return null;
    }
}