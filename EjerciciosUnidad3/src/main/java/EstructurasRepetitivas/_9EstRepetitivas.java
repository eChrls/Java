/*
9. Desarrolla un programa que lea tu edad e indique lo siguiente:

Si es < 18, el programa mostrará: “No puedes votar”.
Si es 18, “Justo eres mayor de edad”
Si es 25, “Que buena edad”
Si es 35, “Ya deberías tener hijos”
Si es 45, “Deberías pensar en abrir un plan de pensiones”
Si es 55, “Viva la madurez”
Si es 65, “Enhorabuena Jubilado”
Si es >65, “A disfrutar la vejez”
El programa controlará que la edad esté comprendida entre 1 y 120 años,
si no es así, volverá a solicitar la edad.
 */
package EstructurasRepetitivas;

import java.util.*;

public class _9EstRepetitivas {

    public static void main(String[] args) {
        //Es el ejercicio 7 del listado anterior incluyendo un DO con IF para filtrar los mayores
        //de 120 y menores de 1, y un while para repetir el ejercicio si lo cumple.
        Scanner sc = new Scanner(System.in);
        int edad;
        do {
            System.out.print("Introduce tu edad (entre 1 y 120): ");
            edad = sc.nextInt();

            if (edad < 1 || edad > 120) {
                System.out.println("Edad no válida. Por favor, introduce una edad entre 1 y 120.");
            }
        } while (edad < 1 || edad > 120);
        if (edad < 18) {
            System.out.println("No puedes votar");
        } else if (edad == 18) {
            System.out.println("Justo eres mayor de edad");
        } else if (edad == 25) {
            System.out.println("Qué buena edad");
        } else if (edad == 35) {
            System.out.println("Ya deberías tener hijos");
        } else if (edad == 45) {
            System.out.println("Deberías pensar en abrir un plan de pensiones");
        } else if (edad == 55) {
            System.out.println("Viva la madurez");
        } else if (edad == 65) {
            System.out.println("Enhorabuena Jubilado");
        } else if (edad > 65) {
            System.out.println("A disfrutar la vejez");
        }
    }
}
