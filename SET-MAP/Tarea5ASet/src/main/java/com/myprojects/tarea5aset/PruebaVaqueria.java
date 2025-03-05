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

public class PruebaVaqueria {
    public static void main(String[] args) {
        // Creamos una nueva vaquería
        Vaqueria miVaqueria = new Vaqueria();

        // Creamos algunas vacas de ejemplo
        Vaca vaca1 = new Vaca(1, LocalDate.of(2020, 5, 15), "Vaca lechera");
        Vaca vaca2 = new Vaca(2, LocalDate.of(2019, 3, 10), "Vaca de carne");
        Vaca vaca3 = new Vaca(3, LocalDate.of(2021, 7, 20), "Vaca mixta");

        // Añadimos vacas a la vaquería
        System.out.println("Añadiendo vacas:");
        System.out.println("Vaca 1 añadida: " + miVaqueria.anadirVaca(vaca1));
        System.out.println("Vaca 2 añadida: " + miVaqueria.anadirVaca(vaca2));
        System.out.println("Vaca 3 añadida: " + miVaqueria.anadirVaca(vaca3));

        // Comprobamos número de vacas
        System.out.println("\nNúmero de vacas: " + miVaqueria.numeroDVacas());

        // Verificamos si una vaca está en la vaquería
        System.out.println("\n¿Está la vaca 2 en la vaquería? " + miVaqueria.estaVaca(vaca2));

        // Obtenemos todas las vacas
        System.out.println("\nLista de vacas:");
        ArrayList<Vaca> todasLasVacas = miVaqueria.obtenerVacas();
        todasLasVacas.forEach(System.out::println);

        // Damos de baja una vaca
        System.out.println("\nDando de baja la vaca 2:");
        System.out.println("Vaca 2 eliminada: " + miVaqueria.bajaVaca(vaca2));

        // Comprobamos el número final de vacas
        System.out.println("\nNúmero final de vacas: " + miVaqueria.numeroDVacas());
    }
}