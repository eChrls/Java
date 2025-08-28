package clasegenerica;

import clasegenerica.excepciones.PilaException;

public class Main {
    public static void main(String[] args) {
        // Crear una pila de enteros con capacidad 5
        Pila<Integer> pilaEnteros = new Pila<>(5);
        
        try {
            // Agregar elementos a la pila
            pilaEnteros.poner(1);
            pilaEnteros.poner(2);
            pilaEnteros.poner(3);
            System.out.println(pilaEnteros.toString());
            System.out.println("Elemento sacado: " + pilaEnteros.sacar());
            System.out.println(pilaEnteros.toString());
        } catch (PilaException e) {
            System.out.println(e.obtenerMensajeError());
        }

        // Crear una pila de cadenas con capacidad 3
        Pila<String> pilaCadenas = new Pila<>(3);
        try {
            // Agregar elementos a la pila
            pilaCadenas.poner("Hola");
            pilaCadenas.poner("Mundo");
            System.out.println(pilaCadenas.toString());
            System.out.println("Elemento sacado: " + pilaCadenas.sacar());
            System.out.println(pilaCadenas.toString());
            pilaCadenas.poner("Genericos");
            pilaCadenas.poner("Java");
            System.out.println(pilaCadenas.toString());
            // Intentar agregar un elemento que supera la capacidad
            // Esto lanzará una excepción PilaException
            pilaCadenas.poner("Excepción"); 
            
        } catch (PilaException e) {
            System.out.println(e.obtenerMensajeError());
        }

    }
}