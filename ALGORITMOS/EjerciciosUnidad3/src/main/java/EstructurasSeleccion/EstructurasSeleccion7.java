/*7. Desarrolla un programa que lea tu edad e indique lo siguiente:
Si es < 18, el programa mostrará: “No puedes votar”.
Si es 18, “Justo eres mayor de edad”
Si es 25, “Que buena edad”
Si es 35, “Ya deberías tener hijos”
Si es 45, “Deberías pensar en abrir un plan de pensiones”
Si es 55, “Viva la madurez”
Si es 65, “Enhorabuena Jubilado”
Si es >65, “A disfrutar la vejez”
 */
package EstructurasSeleccion;
import java.util.Scanner;
public class EstructurasSeleccion7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu edad: ");
        //Guardamos la edad
        int edad = sc.nextInt();
        //Condicion if y else if para clasificar segun edad
        if (edad < 18) {
            System.out.println("No puedes votar");
        } else if (edad == 18) {
            System.out.println("Justo eres mayor de edad");
        } else if (edad == 25) {
            System.out.println("Qué buena edad");
        } else if (edad == 35) {
            System.out.println("Ya deberías tener hijos");
        } else if (edad == 45) {
            System.out.println("Deberías pensar en abrir un plan de pensiones");
        } else if (edad == 55) {
            System.out.println("Viva la madurez");
        } else if (edad == 65) {
            System.out.println("Enhorabuena Jubilado");
        } else if (edad > 65) {
            System.out.println("A disfrutar la vejez");
        }
     }
}
