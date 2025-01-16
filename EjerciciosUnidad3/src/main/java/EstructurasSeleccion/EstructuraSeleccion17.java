/*17. Realiza un programa que, con base en un número proporcionado (1-7), 
indique el día de la semana que le corresponde (L-D), suponiendo que 1 corresponde a 
lunes, 2 a martes y así sucesivamente.*/
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructuraSeleccion17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Solicitamos un número del 1 al 7
        System.out.print("Introduce un número del 1 al 7: ");
        int dia = sc.nextInt();
        // Determinamos el día de la semana con un switch
        //Nombramos nombreDia como String
        String nombreDia;
        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Número no válido. Debe ser entre 1 y 7.";
                break;
        }
        // Mostramos el resultado
        System.out.println("El día de la semana correspondiente es: " + nombreDia);
    }
}

