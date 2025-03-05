/* 
Ejercicio de repaso:
Factorial :
n!= n * (n-1)!
0! = 1
1! = 1
2! = 2 * 1
3! = 3 * 2 * 1
4! = 4 * 3 * 2 * 1
Programa que calcule cualquier factorial*/

package EjerciciosNavidad;

import javax.swing.JOptionPane;

public class Factorial {

    public static int CalculoFactorial() {

        int factorial = 0;
        String fac = "";
        int resultado = 1; // Inicializamos el resultado en 1 porque multiplicamos
        int contador;

        // Bucle para pedir al usuario un número válido
        do {
            try {
                fac = JOptionPane.showInputDialog("Introduce el número entero del que quieras saber el factorial: ");
                factorial = Integer.parseInt(fac);
                if (factorial < 0) {
                    System.out.println("Por favor, introduce un número entero no negativo.");
                    factorial = 0; // Si el número es negativo, lo reiniciamos a 0 para continuar pidiendo el valor
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Introduce un número entero por favor, caracter incorrecto.");
            }
        } while (factorial <= 0); // El bucle se repetirá hasta que el número sea válido

        // Cálculo del factorial
        for (contador = factorial; contador > 1; contador--) {
            resultado *= contador; // Multiplicamos el resultado por cada número
        }

        return resultado; // Devolvemos el resultado del cálculo
    }
}

//    public static int CalculoFactorial(){
//
//    int factorial = 0;
//    String fac = "";
//    int contador = 0;
//    int resultado = 0;
//
//    do{
//    
//    try {
//            fac = JOptionPane.showInputDialog("Introduce el número entero del que quieras saber el factorial: ");
//            factorial = Integer.parseInt(fac);
//
//        } catch (NumberFormatException nfe) {
//            System.out.println("Introduce un número entero por favor, caracter incorrecto. ");
//        }
//
//    }while(false); 
//    
//    do{
//        if (factorial == 0){
//            factorial = 1; 
//        }else{
//        
//       contador = factorial; 
//       
//       resultado = factorial * contador;
//       resultado += resultado; 
//       contador --; 
//        }
//        
//    }while (contador > 0);
//    
//    return resultado; 
//    }
//CORREGIDO

////OPTIMIZADO
//    package EjerciciosNavidad;
//
//import javax.swing.JOptionPane;
//
//public class Factorial {
//
//    public static int CalculoFactorial() {
//
//        int factorial = 0;
//        int resultado = 1; // Inicializamos el resultado en 1, ya que multiplicamos
//
//        // Bucle para pedir al usuario un número válido
//        while (true) {
//            try {
//                factorial = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número entero del que quieras saber el factorial: "));
//                if (factorial < 0) {
//                    System.out.println("Por favor, introduce un número entero no negativo.");
//                } else {
//                    break; // Si el número es válido, salimos del bucle
//                }
//            } catch (NumberFormatException nfe) {
//                System.out.println("Introduce un número entero por favor, caracter incorrecto.");
//            }
//        }
//
//        // Cálculo del factorial con un ciclo for optimizado
//        for (int i = 1; i <= factorial; i++) {
//            resultado *= i; // Multiplicamos el resultado por cada número de 1 a factorial
//        }
//
//        return resultado; // Devolvemos el resultado del cálculo
//    }
//}
/*Eliminación de do-while innecesarios: Se ha sustituido el bucle do-while por un bucle while(true) para pedir el número de forma continua 
hasta que el usuario ingrese un número válido. Esto hace que el código sea más claro y evita la necesidad de tener que usar un valor arbitrario (0) 
para reiniciar el bucle.

Simplificación de la lógica del bucle: En lugar de usar un ciclo for con decrementos y una variable contador, 
ahora utilizamos un ciclo for simple que va desde 1 hasta el número ingresado (factorial). 
Esto hace que el código sea más directo y fácil de entender.

Mejor manejo de la entrada: Eliminamos el uso de una variable String innecesaria para almacenar la entrada antes de convertirla en entero. 
El valor se convierte directamente usando Integer.parseInt(), lo que simplifica el flujo de trabajo.

Eliminación de variables no necesarias: Se eliminan variables intermedias que no aportan nada al proceso, como contador, 
que era innecesaria para controlar el bucle.
*/