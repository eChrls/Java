/*1.- Escribe un programa que muestre cada elemento de un array de enteros y 
sume todos sus elementos. Instancia e inicializa el array en el programa, sin 
leer nada por teclado, con los siguientes valores {100, 200, 300, 400, 500, 600}.*/

package EstructurasDeAlmacenamiento;


public class EjercicioArrays1 {
    
    public static void main(String[] args) {
        //declaramos e inicializamos el array
        int[] enteros = {100, 200, 300, 400, 500, 600};
        int suma = 0;
        
        // Bucle for para recorrer, mostrar y sumar los elementos del array de enteros
        for (int i = 0; i < enteros.length; i++) {
            System.out.print(enteros[i] + " - ");
            suma += enteros[i];
        }
        
        System.out.println("Suma del array = " + suma);
    }
}