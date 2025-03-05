
package EstructurasDeAlmacenamiento;

public class ForEach {

//metodo calcular media negativos for each del ejercicio 3
     public static void mediaN(int[] numeros){
        int sumaN = 0;
         
         
        for (int elemento : numeros) {
            if (elemento < 0) {
                sumaN += elemento;
            }
        }
     }
}
