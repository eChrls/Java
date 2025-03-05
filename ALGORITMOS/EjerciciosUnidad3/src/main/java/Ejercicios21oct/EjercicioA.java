/*A. Imprimir por pantalla las 10 tablas de multiplicar, del 1 al 10.*/
package Ejercicios21oct;

public class EjercicioA {

    public static void main(String[] args) {
        //inicializamos resultado fuera del bucle
        int resultado = 0;
            
        //bucle for doble para recorrer del 1 al 10 dentro de i. 
        for (int i = 1; i < 11; i++) {

            for (int j = 1; j < 11; j++) {
                resultado = i * j;
                System.out.println(resultado);

            }

        }

    }

}
