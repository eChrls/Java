/*
 9. Un algoritmo que lea tres números e 
indique si el tercero es igual a la suma del primero y el segundo.
 */
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructurasSeleccion9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        //Guardamos el primer numero
        double num1 = sc.nextDouble();
        //Guardamos el segundo número
        System.out.print("Introduce el segundo número: ");
        double num2 = sc.nextDouble();
        //y el tercero
        System.out.print("Introduce el tercer número: ");
        double num3 = sc.nextDouble();
        //condicion if para comprobar si el tercero es igual o no a la suma de los dos primeros
        if (num3 == num1 + num2) {
            System.out.println("El tercer número es igual a la suma de los dos primeros");
        } else {
            System.out.println("El tercer número NO es igual a la suma de los dos primeros");       
    }
}   
}
