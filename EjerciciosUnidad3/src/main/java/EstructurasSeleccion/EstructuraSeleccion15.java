/* 15. La asociación de vinicultores tiene como política fijar el precio inicial al kilo de 
uva a principio de la temporada de vendimia. Este año, el precio inicial es 1.23€ el kilo 
de uva. Las uvas se clasifican en tipos A y B, y además en tamaños 1 y 2. Se requiere 
determinar cuánto recibirá un productor por la uva que entrega a la asociación, considerando 
lo siguiente: si es de tipo A, se le suman 20 céntimos al precio inicial cuando es de 
tamaño 1; y 30  céntimos si es de tamaño 2. Si es de tipo B, se rebajan 30 céntimos 
cuando es de tamaño 1, y 50 céntimos cuando es de tamaño 2. Realiza un programa para 
determinar la ganancia obtenida a partir del tipo y tamaño de la uva, del precio inicial 
del kilo y del total de kilos a vender. */
package EstructurasSeleccion;
import java.util.*;
public class EstructuraSeleccion15 {
public static void main(String[] args) {
        // primera variable, precio inicial, declarada
        double precioInicial = 1.23;
        Scanner sc = new Scanner(System.in);
        // Pedimos y guardamos el tipo de uva
        System.out.print("Introduce el tipo de uva (A o B): ");
        char tipo = sc.next().toUpperCase().charAt(0);
        // Pedimos al usuario el tamaño de la uva (1 o 2)
        System.out.print("Introduce el tamaño de la uva (1 o 2): ");
        int tamaño = sc.nextInt();
        // Por último pedimos al usuario la cantidad de kilos a vender
        System.out.print("Introduce la cantidad de kilos a vender: ");
        double kilos = sc.nextDouble();
        // Nombramos variable para almacenar el precio final por kilo
        double precioFinal = precioInicial;
        // Condición IF en función del tipo y tamaño de la uva
        if (tipo == 'A') {
            if (tamaño == 1) {
                precioFinal += 0.20; // Se suman 20 céntimos
            } else if (tamaño == 2) {
                precioFinal += 0.30; // Se suman 30 céntimos
            }
        } else if (tipo == 'B') {
            if (tamaño == 1) {
                precioFinal -= 0.30; // Se rebajan 30 céntimos
            } else if (tamaño == 2) {
                precioFinal -= 0.50; // Se rebajan 50 céntimos
            }
        } else {
            System.out.println("Tipo de uva no válido.");
        }
        // Calcular la ganancia total
        double gananciaTotal = precioFinal * kilos;
        // Mostrar el resultado
        System.out.printf("El precio final por kilo es: %.2f€\n", precioFinal);
        System.out.printf("La ganancia total por la venta de %.2f kilos es: %.2f€\n", kilos, gananciaTotal);
    }    
}
