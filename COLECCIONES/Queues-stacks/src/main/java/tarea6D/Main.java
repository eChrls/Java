/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea6D;

/**
 *
 * @author carlos
 */
public class Main {
    public static void main(String[] args) {

        try {
            Estructura<Integer> pilaMain = new Pila<>(5);
            Estructura<String> colaMain = new Cola<>(5);
            
            System.out.println("Pruebas con Pila : ");
            pilaMain.añadir(1);
            pilaMain.añadir(2);
            pilaMain.añadir(3);
            pilaMain.añadir(4);
            pilaMain.añadir(5);
            System.out.println("Número de elementos en la pila: " + pilaMain.numeroElementosGuardados());

            // Intentar añadir un elemento más para probar la excepción de pila llena
            try {
                pilaMain.añadir(6);
            } catch (EstructuraException e) {
                System.err.println("Error al añadir (Pila): " + e.obtenerExcepcion());
            }
            // Quitar elementos de la Pila
            System.out.println("\nQuitando elementos de la pila...");
            System.out.println("Elemento retirado: " + pilaMain.quitar());
            System.out.println("Número de elementos en la pila después de quitar: " + pilaMain.numeroElementosGuardados());
            System.out.println("Elemento retirado: " + pilaMain.quitar());

            // Intentar quitar de una pila casi vacía
            System.out.println("Elemento retirado: " + pilaMain.quitar());
            System.out.println("Número de elementos en la pila después de quitar: " + pilaMain.numeroElementosGuardados());
            try {
                pilaMain.quitar(); // Intentar quitar de una pila vacía
            } catch (EstructuraException e) {
                System.err.println("Error al quitar (Pila): " + e.obtenerExcepcion());
            }


            colaMain.añadir("A");
            colaMain.añadir("B");
            colaMain.añadir("C");
            colaMain.añadir("D");
            colaMain.añadir("E");

            System.out.println("Número de elementos en la cola: " + colaMain.numeroElementosGuardados());

            // Intentar añadir un elemento más para probar la excepción de cola llena
            try {
                colaMain.añadir("Cuarto");
            } catch (EstructuraException e) {
                System.err.println("Error al añadir (Cola): " + e.obtenerExcepcion());
            }

            // Quitar elementos de la Cola (desencolar)
            System.out.println("\nQuitando elementos de la cola...");
            System.out.println("Elemento retirado: " + colaMain.quitar());
            System.out
                    .println("Número de elementos en la cola después de quitar: " + colaMain.numeroElementosGuardados());
            System.out.println("Elemento retirado: " + colaMain.quitar());
            System.out.println("Elemento retirado: " + colaMain.quitar());

            // Intentar quitar de una cola vacía
            try {
                colaMain.quitar();
            } catch (EstructuraException e) {
                System.err.println("Error al quitar (Cola): " + e.obtenerExcepcion());
            }


        } catch (EstructuraException e) {
            System.out.println(e.obtenerExcepcion());
        }
    }

}
