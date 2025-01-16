/*
 3.- Escribir un programa que lea números enteros entre 1 y 20 desde teclado. 
Se debe generar un histograma con las frecuencias de cada entero en la secuencia.  
Para representar las barras del histograma hay que utilizar secuencias del carácter 
‘*’. El programa finaliza al introducir un cero. 
Por ejemplo, la secuencia: 1, 1, 5, 1, 2, 7, 3, 0 generaría la siguiente salida:
1: *
2: *
3: *****
4: *
5: **
6: *******
7: ***
...
 */
package EstructurasDeAlmacenamiento.ArrayList;

import java.util.*;

public class EjArrayList3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        int valores = 0;
        int num = 0;
        System.out.println("Introduce valores para obtener histograma. Introduce 0 para acabar");
        do {

            valores = sc.nextInt();
            if (valores == 0) {
                break;
            }

            lista.add(valores);

            for (int i = 0; i < lista.size(); i++) {
                num = lista.get(i);
                System.out.print((i + 1) + ": ");
                for (int j = 0; j < num; j++) {
                    System.out.print("*");

                }
            }

        } while (valores != 0);

    }

}
