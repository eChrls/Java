//7. Mostrar la tabla de multiplicar de un número. Para ello el algoritmo preguntará
//  el número del que se quiere saber su tabla de multiplicar y la mostrará desde 1 hasta 10.
package EstructurasRepetitivas;

import java.util.*;

public class _7EstRepetitivas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Inicializamos las variables
        int numero = 1;
        int tabla = 1;
        //Iniciamos bucle DO para guardar el numero.
        do {
            System.out.println("Este es un programa para ver las tablas de multiplicar del 1 al 10. Inserta el numero de la tabla que quieras ver");
            numero = sc.nextInt();
            //Bucle WHILE para la condición que sea entre 1 y 10.
        } while (numero <= 1 && numero >= 10);
        //Bucle for para desarrollar el programa con la tabla
        for (int i = 1; i < 11; i++) {
            tabla = numero * i;
            System.out.println(tabla);
        }
    }
}
