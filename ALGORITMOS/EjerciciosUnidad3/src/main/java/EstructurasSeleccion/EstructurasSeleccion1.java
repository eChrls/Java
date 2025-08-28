/*1. Algoritmo que declare una variable B  y le asigna un valor.  A continuación 
se mostrará un mensaje indicando si el valor de B es positivo, negativo o cero. */
package EstructurasSeleccion;

public class EstructurasSeleccion1 {
    public static void main(String[] args) {
    //asignamos valor a la variable B
    int B = -4;
    
    //Verificamos si es positiva, negativa o cero.
    if (B > 0) { 
        System.out.println("B es positiva.");
    }else if (B < 0) {
        System.out.println("B es negativa.");
    }else
        System.out.println("B es cero.");
     }
}
