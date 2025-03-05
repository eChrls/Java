//8. Realiza un algoritmo que muestre los números del 1 al 50,
//  sin mostrar los múltiplos de cinco.
package EstructurasRepetitivas;

public class _8EstRepetitivas {

    public static void main(String[] args) {

        //bucle FOR más IF. For para llegar hasta 50 y IF declara que queremos solo las %5=0.
        for (int i = 1; i <= 50; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }

        }
    }
}
