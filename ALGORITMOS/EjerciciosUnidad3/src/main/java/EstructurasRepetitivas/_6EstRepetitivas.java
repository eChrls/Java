//6. Hacer un programa que lea una serie de números enteros, precedida del número total 
//  de enteros a leer. El programa debe calcular el total de números pares, 
//  el total de números impares, y el promedio de todos los números.
package EstructurasRepetitivas;

import java.util.*;

public class _6EstRepetitivas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Inicializamos variables fuera de los bucles
        int numeros = 0;
        int contadorPar = 0;
        int contadorImpar = 0;
        int contador = 0;
        //pedimos la cantidad de números para guardarla en un contador.
        System.out.println("Introduce el numero total de numeros que quieres que calcule");
        int cantidad = sc.nextInt();
        do {
            System.out.println("Introduce los numeros");
            numeros = sc.nextInt();
            if (numeros % 2 == 0) {
                contadorPar++;
            } else {
                contadorImpar++;
            }
            numeros += numeros;
            contador++;
        } while (contador != cantidad);
        double media = (double) numeros / contador;

        System.out.println("La cantidad de numeros pares es " + contadorPar);
        System.out.println("La cantidad de números impares es   " + contadorImpar);
        System.out.println("La media de todos los numeros es    " + media);
    }
}
