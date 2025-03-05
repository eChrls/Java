
/* 4.- Implementa un programa que genere una lista de 50 números pin aleatorios
diferentes. En un método de clase, que recibe una lista de pines 
y un digito(0-9) se debe devolver en otra lista aquellos pines que 
contienen ese número. Si no hay ninguno devuelve una lista vacía. 
En el programa principal, pide un pin al usuario y usando la función 
anterior se debe saber si ese pin está en la lista inicial o no. 
Los dígitos del pin no se repiten y se guardan en un array de int.
 */
package EstructurasDeAlmacenamiento.ArrayList;

import static EstructurasDeAlmacenamiento.ArrayList.EjArrayList4.listaFiltrada;
import java.util.*;

public class EjArrayList4 {

    public static void main(String[] args) {
        //El programa genera automaticamente 50 listas con pines aleatorios
        //inicializamos lista, array y random para generar la lista de 50 arrays
        Random random = new Random();

        ArrayList<int[]> listaPin = new ArrayList<>(50);
        int[] pin = new int[4];

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < pin.length; j++) {
                pin[j] = random.nextInt(10);
            }
            listaPin.add(pin);
        }
        
        Scanner sc = new Scanner (System.in);
        //Ya hemos hecho el metodo para filtrar
        //Pedimos pin al usuario para saber si ese pin esta en la lista inicial o no
        System.out.println("Introduce un pin número a número para saber si esta en la lista");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce un número");
            int num = sc.nextInt();
                listaFiltrada(listaPin, pin, num);
                
            }
            System.out.println("Los pines que incluyen esos numeros son : " + EjArrayList4.listaFiltrada(listaPin, pin, 0));

                
            
    }

    public static ArrayList<int[]> listaFiltrada(ArrayList<int[]> lista, int[] pin, int num) {
        ArrayList<int[]> listaPinesFiltrada = null;

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < pin.length; j++) {
                if (num == pin[i]) {
                    listaPinesFiltrada.add(pin);                                        
                }         
            }
        }
        return listaPinesFiltrada;
    }
}

