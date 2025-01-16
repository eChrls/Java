/* Un algoritmo que calcule el IMC y en función del valor muestre lo siguiente:
ÍNDICE MASA CORPORAL
CLASIFICACIÓN 
<16.00
16.00 - 16.99
17.00 - 18.49
18.50 - 24.99
25.00 - 29.99
30.00 - 34.99
35.00 - 40.00
>40.00
Infrapeso: Delgadez Severa
Infrapeso: Delgadez moderada
Infrapeso: Delgadez aceptable
Peso Normal
Sobrepeso
Obeso: Tipo I
Obeso: Tipo II
Obeso: Tipo III
 */
package EstructurasSeleccion;

import java.util.Scanner;

public class EstructuraSeleccion11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Cogemos el peso en kilos
        System.out.print("Introduce tu peso en kg: ");
        double peso = sc.nextDouble();
        //Cogemos la altura en metros
        System.out.print("Introduce tu altura en metros: ");
        double altura = sc.nextDouble();
        //hacemos la fórmula IMC
        double imc = peso / (altura * altura);
        System.out.printf("Tu IMC es: %.2f\n", imc);
        //condición if + else if según resultado
        if (imc < 16.00) {
            System.out.println("Infrapeso: Delgadez Severa");
        } else if (imc < 17.00) {
            System.out.println("Infrapeso: Delgadez Moderada");
        } else if (imc < 18.50) {
            System.out.println("Infrapeso: Delgadez Aceptable");
        } else if (imc < 25.00) {
            System.out.println("Peso Normal");
        } else if (imc < 30.00) {
            System.out.println("Sobrepeso");
        } else if (imc < 35.00) {
            System.out.println("Obeso: Tipo I");
        } else if (imc < 40.00) {
            System.out.println("Obeso: Tipo II");
        } else {
            System.out.println("Obeso: Tipo III");
        }
    }
}
