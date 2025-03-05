/*
 4. Algoritmo que lea dos números por teclado y muestre el resultado de la división 
del primero por el segundo. 
Se debe comprobar que el divisor no puede ser cero.
 */
package EstructurasSeleccion;
import java.util.*;
public class EstructurasSeleccion4 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   
    // Leer dos números
        System.out.print("Introduce el dividendo: ");
        double dividendo = sc.nextDouble();
        System.out.print("Introduce el divisor: ");
        double divisor = sc.nextDouble();
    //Comprobamos que no sea 0
    if (divisor != 0){
        double resultado = dividendo / divisor;
        System.out.printf("El resultado de la división es: %.2f%n", resultado);
    }else{
        System.out.println("Error: El divisor no puede ser cero. Vuelve a empezar.");
    }
    }
}
