/*
 10. Un algoritmo que lea un importe bruto y calcule su importe neto, 
teniendo en cuenta que si el bruto es mayor de 15.000 se le aplicará un 16% de 
impuestos al importe bruto para calcular la deducción, 
en caso contrario se le aplicará un 10%. (Neto = Bruto – Deducción).
 */
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructuraSeleccion10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el importe bruto: ");
        //coger el dato de la cantidad bruta
        double bruto = sc.nextDouble();
        //nombramos la deducción y hacemos la condición if + la fórmula de la deducción
        double deduccion;
        if (bruto > 15000) {
            deduccion = bruto * 0.16;
        } else {
            deduccion = bruto * 0.10;
        }
        //una vez calculada la deducción obtenemos el neto
        double neto = bruto - deduccion;
        System.out.println("El importe neto es: " + neto);
    }
}
 
