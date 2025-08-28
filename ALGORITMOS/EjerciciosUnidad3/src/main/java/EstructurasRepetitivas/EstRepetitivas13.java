/*13. Un banco establece que la clave secreta para acceso a sus cajeros automáticos debe ser un número de cuatro dígitos, tales que ninguno de ellos se repita y que la suma de 
los dos dígitos intermedios sea impar. Escribir un programa que permita introducir los cuatro dígitos y compruebe si los dígitos introducidos forman una clave válida.*/
package EstructurasRepetitivas;

import java.util.*;

public class EstRepetitivas13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Solicitamos al usuario ingresar una clave de cuatro dígitos
        System.out.print("Introduce un número de cuatro dígitos: ");
        int clave = sc.nextInt();

        // Verificamos que la clave tenga exactamente 4 dígitos , primera condición
        if (clave < 1000 || clave > 9999) {
            System.out.println("La clave no es válida. Debe tener exactamente 4 dígitos.");
        } else {
            // Extraemos cada dígito de la clave ingresada con regla matemática 
            int d1 = clave / 1000;            // Primer dígito (miles)
            int d2 = (clave / 100) % 10;      // Segundo dígito (centenas)
            int d3 = (clave / 10) % 10;       // Tercer dígito (decenas)
            int d4 = clave % 10;              // Cuarto dígito (unidades)

            // Verificamos si los dígitos son únicos con boolean, segunda condición
            boolean digitosUnicos = (d1 != d2) && (d1 != d3) && (d1 != d4)
                    && (d2 != d3) && (d2 != d4) && (d3 != d4);

            // Verificamos si la suma de los dos dígitos intermedios es impar con boolean también, tercera condición
            boolean sumaIntermediosImpar = ((d2 + d3) % 2 != 0);

            // Comprobamos si cumple ambas condiciones, última condición
        
        if (digitosUnicos && sumaIntermediosImpar) {
            System.out.println("La clave es válida.");
        } else {
            System.out.println("La clave no es válida.");
        }
        }
    }
    }
