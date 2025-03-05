/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myprojects.tarea5aset;

/**
 *
 * @author Casa
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class PruebaVaqueriaOrdenada {
    public static void main(String[] args) {
        // Creamos una vaquería ordenada
        VaqueriaOrdenada miVaqueria = new VaqueriaOrdenada();

        // Creamos algunas vacas con IDs diferentes para probar el ordenamiento
        Vaca vaca3 = new Vaca(3, LocalDate.of(2021, 7, 20), "Vaca mixta");
        Vaca vaca1 = new Vaca(1, LocalDate.of(2020, 5, 15), "Vaca lechera");
        Vaca vaca2 = new Vaca(2, LocalDate.of(2019, 3, 10), "Vaca de carne");

        // Añadimos vacas (no importa el orden de inserción)
        System.out.println("Añadiendo vacas:");
        miVaqueria.anadirVaca(vaca3);
        miVaqueria.anadirVaca(vaca1);
        miVaqueria.anadirVaca(vaca2);

        // Comprobamos número de vacas
        System.out.println("\nNúmero de vacas: " + miVaqueria.numeroDVacas());

        // Obtenemos todas las vacas (estarán ordenadas por ID)
        System.out.println("\nLista de vacas ordenadas:");
        ArrayList<Vaca> todasLasVacas = miVaqueria.obtenerVacas();
        todasLasVacas.forEach(System.out::println);
    }
}