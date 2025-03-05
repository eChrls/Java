/*
 12. Un algoritmo que calcule las Kcal consumidas por un deportista en función 
del tiempo de actividad y el tipo de actividad (correr, pedalear o nadar). 
Ten en cuenta que el cuerpo humano consume 800Kcal si corres durante una hora, 
750Kcal si haces bicicleta y 540Kcal si haces natación.
 */
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructuraSeleccion12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pedimos el tiempo en horas
        System.out.print("Introduce el tiempo de actividad en horas: ");
        double tiempo = sc.nextDouble();
        //indicamos que elija opción    
        System.out.println("Selecciona el tipo de actividad: 1 - Correr, 2 - Bicicleta, 3 - Natación");
        int actividad = sc.nextInt();
        //switch para enlazar opción con fórmula    
        double kcal = 0;
        switch (actividad) {
            case 1:
                kcal = 800 * tiempo;
                break;
            case 2:
                kcal = 750 * tiempo;
                break;
            case 3:
                kcal = 540 * tiempo;
                break;
            //En caso de elegir un int fuera de la selección
            default:
                System.out.println("Actividad no válida");
        }
        //fuera del switch el resultado de la fórmula
        System.out.println("Kcal consumidas: " + kcal);
    }
}

