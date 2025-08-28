/*2.- Escribe un programa que, dado un array de enteros de cualquier tamaño, 
busque si un número obtenido por teclado se encuentra en el array e imprima la 
primera posición en la que se encuentra el número. Realiza este ejercicio usando 
un método que reciba el array de elementos y el elemento a buscar y devuelva un 
cero o positivo con el índice donde está el elemento o un negativo si no existe.*/
package EstructurasDeAlmacenamiento;

import java.util.*;

public class EjercicioArrays2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //  Hacemos e inicializamos un array ejemplo
        int[] array = {99, 88, 77, 66, 55, 44, 33, 22, 11, 10, 9, 7, 5, 3, 1};
        
        do {            
        System.out.println("Introduzca un número para comprobar si está incluido: ");

        int numero = s.nextInt();
        //invocamos el metodo
        int posicion = buscarNumero(array, numero);
        //if para filtrar i o -1
        if(posicion > 0 ){
            System.out.println("El número " + numero + " se encuentra en la posición: " + posicion);       
    }else if (posicion <= 0)
            System.out.println("El numero no se encuentra disponible");
       } while (true); 
    }    
    //metodo array con bucle for para retornar i o -1     
    public static int buscarNumero (int[] array, int numero){
     
        for (int i = 0; i < array.length; i++) {
            if (array[i]==numero) {
                return i;
            }
        }
        return -1;
    }  
    
}


