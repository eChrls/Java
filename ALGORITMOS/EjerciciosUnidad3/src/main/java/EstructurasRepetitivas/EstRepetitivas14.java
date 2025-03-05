/*14. En una tienda las personas que van a pagar el importe de su compra llegan a la caja y sacan una bolita de color,
que les dirá que descuento tendrán sobre el total de su compra. Esta bolita se saca de forma aleatoria de un saco, 
sin saber  la bolita que saldrá.  Se sabe que si el color de la bolita es azul el cliente obtendrá un 20% de descuento; 
si es verde un 25% y si es blanca no obtendrá descuento. Escribir un algoritmo que, dado el importe que va a pagar el cliente, 
imprima por pantalla el importe descontado y la bolita que sacó. El programa, una vez finaliza, vuelve a preguntar 
si hay otro cliente en caja para proceder igualmente. El valor de la bolita se establecerá aleatoriamente.*/
package EstructurasRepetitivas;

import java.awt.BorderLayout;
import java.util.*;

public class EstRepetitivas14 {

    public static void main(String[] args) {
        // Creamos un objeto Random para generar números aleatorios
        Random random = new Random();
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Variable para almacenar la respuesta del usuario si quiere atender a otro cliente
        String respuesta;
        // Bucle principal que se repetirá mientras el usuario quiera atender a más clientes
        do {
            // Pedimos al cliente que introduzca el importe de su compra
            System.out.print("Introduce el importe de la compra: ");
            double importe = scanner.nextDouble();
            // Generamos un número aleatorio entre 0 y 2 para seleccionar el color de la bolita
            int bolita = random.nextInt(3);
            // Variables para almacenar el descuento y el color de la bolita
            double descuento = 0;
            String color = "";
            // Usamos una estructura switch para determinar el descuento según el color de la bolita
            switch (bolita) {
                case 0:
                    // Si la bolita es azul (0), el descuento es del 20%
                    color = "azul";
                    descuento = 0.20;
                    break;
                case 1:
                    // Si la bolita es verde (1), el descuento es del 25%
                    color = "verde";
                    descuento = 0.25;
                    break;
                case 2:
                    // Si la bolita es blanca (2), no hay descuento
                    color = "blanca";
                    descuento = 0.00;
                    break;
            }
            // Calculamos el importe descontado
            double importeDescontado = importe * (1 - descuento);
            // Mostramos el resultado al cliente
            System.out.printf("Has sacado una bolita %s. El importe a pagar con el descuento aplicado es: %.2f€%n", color, importeDescontado);

            // Limpiamos el buffer del Scanner
            scanner.nextLine();
            // Preguntamos al usuario si quiere atender a otro cliente
            System.out.print("¿Hay otro cliente en caja? (si/no): ");
            respuesta = scanner.nextLine().toLowerCase();

        } while (respuesta.equals("si"));

        // Mensaje de despedida
        System.out.println("Gracias por usar nuestro sistema de descuentos. ¡Hasta la próxima!");
    }
}
