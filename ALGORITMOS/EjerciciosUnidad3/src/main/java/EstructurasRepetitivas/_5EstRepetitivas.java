//5. Leer una serie de números y calcular la media aritmética, hasta que llegue un cero.
package EstructurasRepetitivas;

import java.util.*;

public class _5EstRepetitivas {
  public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        int total = 0;
        double media = 0;
        int contador = 0;
        do {
            System.out.println("Introduce un numero entero. Cuando pulse 0 se sumaran todos y se calculara su media");
            num = sc.nextInt();
            
            if( num != 0){
            total += num;
            contador++;
            }
        } while (num != 0);
        
        if (contador > 0){
        media = (double) total / contador;
        System.out.printf("La media de los numeros es %.2f%n", media);
        }else{
            System.out.println("No se han introducido numeros para calcular la media");
        }
  }
}
