/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myprojects.pruebasunitarias;

import java.util.Scanner;

/**
 *
 * @author Casa
 */
public class Main {

    public static void main(String[] args) {
        ClasificacionTallas();
    }
    
    public static void ClasificacionTallas(){
        Scanner in = new Scanner(System.in);
        String talla;
        double precio = 0.0;
        System.out.println("Introduzca la talla:(XS,S,M,L,XL,XXL)");
        talla = in.next().toUpperCase();
        System.out.println("Introduzca el precio");
        precio = in.nextDouble();
        Metodos met = new Metodos();
        System.out.println();
        System.out.println("La talla es: "+ met.Tallas(talla));
        System.out.println("El precio final es: " + met.iva(precio));
    }
}
