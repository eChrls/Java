/* 
Ejercicio de repaso:
Factorial :
n!= n * (n-1)!
0! = 1
1! = 1
2! = 2 * 1
3! = 3 * 2 * 1
4! = 4 * 3 * 2 * 1
Programa que calcule cualquier factorial

Suma de digitos
Dado un n.o cualquiera obtener la suma de los digitos
Ej: 623 = 6 + 2 + 3 = 11*/
package EjerciciosNavidad;

import javax.swing.JOptionPane;

public class EjerciciosNavidad {

    public static void main(String[] args) {

        int numeroElegido = 0;
        int resultado = 0;

        do {

            String menu = """
                    Introduce el programa que quieras usar: 
                    1) Factorial  
                    2) Suma digital
                    3) Salir
                    """;
            String menuElegido = JOptionPane.showInputDialog(menu);
            try {
                numeroElegido = Integer.parseInt(menuElegido);
            } catch (NumberFormatException nfe) {
                System.out.println("Introduce un número del 1 al 3.");
            }

            switch (numeroElegido) {

                case 1 -> {
                    resultado = Factorial.CalculoFactorial();
                    System.out.println("El resultado del factorial es: " + resultado);
                    break;
                }

                case 2 -> {
                    resultado = SumaDigital.SumaNumeros();
                    System.out.println("El resultado de la suma digital es: " + resultado);
                    break;
                }

                case 3 -> {
                    System.out.println("Has salido");
                    break;
                }

                default -> {
                    System.out.println("Has elegido una opción incorrecta");
                }

            }

        } while (numeroElegido != 3);

    }

}
