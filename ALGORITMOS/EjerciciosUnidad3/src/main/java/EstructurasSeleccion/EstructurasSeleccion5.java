/*
 5. Algoritmo que lea tres números enteros H, M, S que contienen 
hora, minutos y segundos respectivamente,
y comprueba si la hora que indican es una hora válida.
 */
package EstructurasSeleccion;

import java.util.*;

public class EstructurasSeleccion5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer los valores de H, M, S
        System.out.print("Introduce la hora (H): ");
        int H = sc.nextInt();
        System.out.print("Introduce los minutos (M): ");
        int M = sc.nextInt();
        System.out.print("Introduce los segundos (S): ");
        int S = sc.nextInt();

        // Comprobar si la hora es válida
        if ((H >= 0 && H < 24) && (M >= 0 && M < 60) && (S >= 0 && S < 60)) {
            System.out.println("La hora introducida es válida.");
        } else {
            System.out.println("La hora introducida no es válida.");
        }
    }
    }
