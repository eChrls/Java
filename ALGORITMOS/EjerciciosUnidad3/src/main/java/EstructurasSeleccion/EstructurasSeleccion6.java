/*
 6. Algoritmo que lea una variable int llamada mes y compruebe si el valor corresponde 
a un mes de 30, 31 o 28 días. Se mostrará además el nombre del mes. Se debe comprobar 
que el valor introducido esté comprendido entre 1 y 12. 
 */
package EstructurasSeleccion;

import java.util.Scanner;

public class EstructurasSeleccion6 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Leer el valor de mes
    System.out.println ("Introduce el número del mes (1-12): ");
        int mes = sc.nextInt();
    // If para comprobar que el número está entre 1 y 12.
    if (mes >= 1 && mes<= 12) {
        String nombreMes = "";
        int dias = 0;

        // Switch para relacionar el número con el mes y sus días 
        switch (mes) {
            case 1:
                nombreMes = "Enero";
                dias = 31;
                break;
            case 2:
                nombreMes = "Febrero";
                dias = 28; // O 29 si quieres considerar años bisiestos
                break;
            case 3:
                nombreMes = "Marzo";
                dias = 31;
                break;
            case 4:
                nombreMes = "Abril";
                dias = 30;
                break;
            case 5:
                nombreMes = "Mayo";
                dias = 31;
                break;
            case 6:
                nombreMes = "Junio";
                dias = 30;
                break;
            case 7:
                nombreMes = "Julio";
                dias = 31;
                break;
            case 8:
                nombreMes = "Agosto";
                dias = 31;
                break;
            case 9:
                nombreMes = "Septiembre";
                dias = 30;
                break;
            case 10:
                nombreMes = "Octubre";
                dias = 31;
                break;
            case 11:
                nombreMes = "Noviembre";
                dias = 30;
                break;
            case 12:
                nombreMes = "Diciembre";
                dias = 31;
                break;
        }   
        // Imprimir el resultado
        System.out.printf("El mes de %s tiene %d días.%n", nombreMes, dias);
        //En caso no cumplirse el if
        }else{
        System.out.println("Error: El valor introducido no está entre 1 y 12.");
    }
}
}
