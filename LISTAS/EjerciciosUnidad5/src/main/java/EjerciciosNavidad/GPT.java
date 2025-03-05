/*
Ejercicio:
Crea un ArrayList de enteros.
Añade 10 números aleatorios entre 1 y 100 a la lista.
Elimina el número en la posición 5.
Mueve el número que se encuentra en la posición 2 a la última posición de la lista.
Calcula la suma de todos los números en la lista.
Muestra la lista final y la suma.
 */
package EjerciciosNavidad;

import java.util.ArrayList;
import java.util.Random;

public class GPT {

    public static void main(String[] args) {
        
        ArrayList<Integer> lista = new ArrayList<>(10);
        int contador = 0; 
        int num = 0;
        int resultado= 0;
        Random r = new Random ();
        do{
        lista.add(r.nextInt(0,100));
        contador++; 
        }while ( contador < 10);
        System.out.println("lista original = " + lista);
        lista.remove(5);
        lista.addLast(2);
        for (int i = 0; i < lista.size(); i++) {
            num = lista.get(i);
            resultado += num; 
            
        }
        System.out.println("La lista es " + lista + "\n y su suma es " + resultado);
    }



    
}
