/*
Ejercicio:
Objetivo: Dada una lista de 20 números aleatorios entre 1 y 100, realiza las siguientes operaciones:
Ordena la lista en orden ascendente.
Mueve los 5 primeros números de la lista al final.
Encuentra el segundo número más grande en la lista.
Calcula el promedio de los primeros 10 números.
Elimina todos los números pares.
Si la lista contiene más de 10 números después de las eliminaciones, divide la lista en dos sublistas: una con los primeros 5 números y otra con los 5 últimos.
Muestra las dos sublistas y el promedio calculado.
 */
package EjerciciosNavidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GPT2 {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>(20);
        Random r = new Random();
        

//        do {
//            lista.add(r.nextInt(1, 101));
//            contador++;
//        } while (contador < 20);
        for (int i = 0; i < 20; i++) {
            lista.add(r.nextInt(1, 101));
        }
        //LISTA CON 20 ALEATORIOS DE 1 A 100
        System.out.println("Lista original: " + lista);
        //LISTA ORDENADA ASCENDENTE
        Collections.sort(lista);//descendiente .sort(lista, Collections.reverseOrder());
        System.out.println("Lista ordenada ascendiente" + lista);
        //LOS PRIMEROS 5 NUMEROS DEPLAZADOS AL FINAL.
//        lista.remove(19);
//        lista.remove(18);
//        lista.remove(17);
//        lista.remove(16);
//        lista.remove(15);
//        lista.add(15, lista.getFirst());
//        lista.add(16, lista.get(1));
//        lista.add(17, lista.get(2));
//        lista.add(18, lista.get(3));
//        lista.add(19, lista.get(4));
        List<Integer> primerosCinco = new ArrayList<>(lista.subList(0, 5));
        lista.removeAll(primerosCinco);
        lista.addAll(primerosCinco);
        System.out.println("Lista con los 5 primeros al final " + lista);
        //MOSTRANDO SOLO EL SEGUNDO NÚMERO MÁS GRANDE
//        Collections.sort(lista);
//        System.out.println("El segundo numero más grande es " + lista.get(18));
        Collections.sort(lista);
        System.out.println("El segundo número más grande es " + lista.get(lista.size()-2));
        //EL PROMEDIO DE LOS 10 PRIMEROS NÚMEROS
//        int total = lista.get(0) + lista.get(1) + lista.get(2) + lista.get(3) + lista.get(4);
//        double media = total/5;
//        System.out.println("La media de los primeros cinco numeros es " + media);
          double suma = 0.0; 
          for (int i = 0; i < 10; i++) {
            suma += lista.get(i);
        }
          double promedio = suma / 10; 
          System.out.println("La media de los diez primeros números es " + promedio);
        //ELIMINA TODOS LOS PARES
//        for (int i = lista.size()-1; i > 0; i--) {
//            if (lista.get(i)% 2 == 0){
//                lista.remove(i);
//            }
//        }
        lista.removeIf(num -> num % 2 == 0);
        System.out.println("Lista sin pares = " + lista);
        //DIVIDIR EL TOTAL EN DOS SUBLISTAS
//        System.out.println("Sublista de la primera mitad de números" + lista.subList(lista.get(0), lista.indexOf(lista.size()/2)));
//        System.out.println("Sublista de la segunda mitad de números" + lista.subList(lista.get(lista.size()/2), lista.get(lista.getLast())));
        if (lista.size() > 10){
            List<Integer> primeroscinco = lista.subList(0, 5);
            List<Integer> ultimoscinco = lista.subList(lista.size()-5, lista.size());
            System.out.println("Primeros cinco = " + primeroscinco + "\n Ultimos cinco = " + ultimoscinco);
        }
        else {
                System.out.println("La lista tiene 10 o menos numeros, no se puede dividir en listas de 5");
        }

    }

}
