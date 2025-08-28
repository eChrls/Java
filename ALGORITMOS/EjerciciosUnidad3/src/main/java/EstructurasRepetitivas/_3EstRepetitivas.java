//3. Algoritmo que muestre los números del 1 al 100. Usa las tres estructuras repetitivas.
package EstructurasRepetitivas;

public class _3EstRepetitivas {

    public static void main(String[] args) {

//FOR para mostrar i de 1 a 100
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
//Inicializamos i en 0 y metemos sout dentro del bucle para que muestre i de 1 a 100.
        int x = 0;
        while (x < 100) {
            x++;
            System.out.println(x);
        }
//Estructura parecida a la anterior, instrucciones en DO y condicion en WHILE
        int j = 0;
        do {
            j++;
            System.out.println(j);
        } while (j < 100);

    }
}
