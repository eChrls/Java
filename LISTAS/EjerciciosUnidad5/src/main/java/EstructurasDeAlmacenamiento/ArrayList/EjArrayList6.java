/*
 6.- Crear un programa con una lista (ArrayList) de números enteros Integer.  En
una clase llamada OperacionesLista, incluye los siguientes métodos:
Generar una lista de números aleatorios en el intervalo [10 :
100]. Este método devuelve una lista rellena de números según el tamaño
indicado en el parámetro. Imprimir una lista de enteros.
Imprimir la suma de los números pares de una lista de enteros.
Imprimir la cantidad de números impares de la lista. 
Devolver el elemento mayor. Devolver el elemento menor.
Devolver el tamaño de la lista. Borrar un elemento de la lista, según su posición.
Borrar un elemento de la lista, según su valor. Si hay varios, los borra todos.
Modificar un elemento de la lista, según su posición. Prueba los métodos en el main.
 */
package EstructurasDeAlmacenamiento.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjArrayList6 {

    public static void operacionesLista(ArrayList<Integer> lista, int tamaño) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño de la lista a generar: ");
        tamaño = sc.nextInt();
        int sumaPares = 0;
        int sumaImpares = 0;
        ArrayList<Integer> listaPares = new ArrayList<>();
        ArrayList<Integer> listaImpares = new ArrayList<>();

        for (int i = 0; i < tamaño; i++) {
            int aleatorio = random.nextInt(10, 101);
            lista.add(aleatorio);
            if (aleatorio % 2 == 0) {
                listaPares.add(aleatorio);
                sumaPares += aleatorio;
            } else {

                listaImpares.add(aleatorio);
                sumaImpares += aleatorio;
            }
        }
        System.out.println("La lista contiene los siguientes valores: " + lista);
        System.out.println("La lista tiene los siguientes impares" + listaImpares + " y estos suman = " + sumaImpares);
        System.out.println("La lista tiene los siguientes pares" + listaPares + " y estos suman = " + sumaPares);

        int maximo = 0;
        int minimo = 100;
        for (int i = 0; i < lista.size(); i++) {
            if (maximo < lista.get(i)) {
                maximo = lista.get(i);
            }
        }
        System.out.println("El número más alto de la lista es el : " + maximo);

        for (int i = 0; i < lista.size(); i++) {
            if (minimo > lista.get(i)) {
                minimo = lista.get(i);
            }
        }
        System.out.println("El número más bajo de la lista es el : " + minimo);
            
        System.out.println("Introduce un valor que quieras eliminar de la lista " + lista);
        int eliminado = sc.nextInt();
        do {
            lista.remove(Integer.valueOf(eliminado));
        } while (lista.contains(eliminado));
        System.out.println("Se han eliminado todos los valores con ese digito");
        System.out.println(lista);        
        int ultimaposicion = lista.getLast();

        System.out.println("Introduce una posición del array que quieras eliminar entre 0 y " + lista.lastIndexOf(ultimaposicion));

        int indice = sc.nextInt();
        lista.remove(indice);
        System.out.println("Se ha eliminado esa posición");
        System.out.println(lista);
        int ultimaposicion2 = lista.getLast();
        System.out.println("Introduce una posición del array que quieras eliminar entre 0 y " + lista.lastIndexOf(ultimaposicion2));
        int ind = sc.nextInt();
        System.out.println("Ahora introduce el valor que quieres añadir en esa posición: ");
        Scanner sc2 = new Scanner(System.in);
        int valor = sc2.nextInt();
        lista.set(ind, valor);
        System.out.println("Esta es la lista final : " + lista);
    }

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList());
        int tamaño = 0;

        EjArrayList6.operacionesLista(lista, tamaño);
    }

}
