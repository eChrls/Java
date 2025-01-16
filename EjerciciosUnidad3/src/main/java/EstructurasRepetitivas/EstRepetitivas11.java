/*11. Realizar un programa que a través de un menú permita realizar las operaciones de sumar, 
restar, multiplicar, dividir y salir. Las operaciones constan de dos operandos. 
El menú se visualizará en pantalla y el programa pedirá de nuevo la opción si el usuario 
introduce alguna incorrecta. Hay que tener en cuenta que no se puede dividir por cero, 
en tal caso se mostrará un mensaje avisando. Ejemplo de ejecución:
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Seleccione la opción deseada: 3
Introduzca el primer operando: 4
Introduzca el segundo operando: 3
Resultado: 12	[Se volvería a mostrar el menú]*/
package EstructurasRepetitivas;

import java.util.*;

public class EstRepetitivas11 {

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        // Bucle para mostrar menu inicial
        do {
            System.out.println("Bienvenido a la calculadora.");
            String menu = """
                          Seleccione la opción deseada: 
                          1. Sumar
                          2. Restar
                          3. Multiplicar
                          4. Dividir
                          5. Salir
                          """;
            System.out.println(menu);
            
            // Leemos la opción
            opcion = sc.nextInt();
            
            // Condición if para calcular o salir
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Introduzca el primer número: ");
                double num1 = sc.nextDouble();
                System.out.print("Introduzca el segundo número: ");
                double num2 = sc.nextDouble();
                
                // Realizamos la operación con variable inicializada siempre fuera del bucle
                double resultado = 0.0;
                switch (opcion) {
                    case 1:
                        resultado = num1 + num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 2:
                        resultado = num1 - num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 3:
                        resultado = num1 * num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 4:
                        if (num2 != 0) {
                            resultado = num1 / num2;
                            System.out.println("Resultado: " + resultado);
                        } else {
                            System.out.println("Error: No se puede dividir por cero.");
                        }
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("Opción incorrecta");
            }
        } while (opcion != 5);
        
        System.out.println("Gracias");
    }
}