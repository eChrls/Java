/*
 13.  Realizar un programa que calcule las raíces de la ecuación:
ax2+bx+c = 0
teniendo en cuenta los siguientes casos:
1- Si a es igual a 0 y b es igual a 0, se imprimirá un mensaje diciendo que la ecuación es degenerada.
2- Si a es cero y b no es igual a cero, existirá una única raíz con valor -c/b.
3- En los demás casos, se utilizará la siguiente fórmula:
x=−bb²−4ac2a

 */
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructuraSeleccion13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Introducimos en double el valor de a, b y c
        System.out.print("Introduce el valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Introduce el valor de b: ");
        double b = sc.nextDouble();

        System.out.print("Introduce el valor de c: ");
        double c = sc.nextDouble();

        // Primera condición (IF) Caso 1: Si a = 0 y b = 0, la ecuación es degenerada
        if (a == 0 && b == 0) {
            System.out.println("La ecuación es degenerada, no tiene solución.");
        }
        // Segunda condición (ELSE IF) Caso 2: Si a = 0 pero b ≠ 0, hay una única solución lineal
        else if (a == 0) {
            double unicaRaiz = -c / b;
            System.out.println("La ecuación es lineal, con una única raíz: " + unicaRaiz);
        }
        // Tercera condición (ELSE) Caso 3: a != 0, utilizamos la fórmula 
        else {
            double raizFormula = b * b - 4 * a * c;
            // Caso 3.1: La raiz de la formula es mayor que 0, dos soluciones reales y distintas
            //Nueva condición IF, ELSE IF y ELSE para resultado positivo, cero o negativo.
            if (raizFormula > 0) {
                double raiz1 = (-b + Math.sqrt(raizFormula)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(raizFormula)) / (2 * a);
                System.out.println("Las raíces son reales y distintas:");
                System.out.println("Raíz 1: " + raiz1);
                System.out.println("Raíz 2: " + raiz2);
            }
            // Caso 3.2: La raiz de la formula es igual a 0, una única solución real (raíz doble)
            else if (raizFormula == 0) {
                double raiz = -b / (2 * a);
                System.out.println("La raíz es real y doble: " + raiz);
            }
            // Caso 3.3: La raiz de la formula es menor que 0, no hay soluciones reales
            else {
                System.out.println("La ecuación no tiene raíces reales.");
            }
        }
    }
}



