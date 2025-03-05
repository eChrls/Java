/*Adapta el ejercicio práctico que realizamos en la tarea 2B según el siguiente enunciado:
Procede a solicitar al usuario el número de habitantes de la población sobre la que queremos 
calcular la tasa. Si este número es menor que 100 o mayor que cuarenta millones 
el programa mostrará un mensaje indicando que el dato está fuera de rango y no realizará 
ninguna acción. En otro caso, se solicitará al usuario el número de contagios teniendo 
en cuenta que este dato debe encontrarse entre cero y el número de habitantes leído 
anteriormente. Si el dato es correcto se procede a calcular la tasa de contagios, 
si no se muestra un mensaje indicando que el número introducido no es válido 
y no se ejecuta ninguna instrucción adicional. Una vez calculada la tasa hay que indicar 
si hay o no hay confinamiento si ésta supera las 200 personas por cada 100000 habitantes.*/
package EstructurasControl;

import java.util.Scanner;

public class EjercicioIfElse3deOctubre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pedimos el número de habitantes
        System.out.println("Introduce el número de habitantes");
        int habitantes = sc.nextInt();
        //Condición para que introduzca datos correctos
        if (habitantes <= 100 || habitantes >= 40000000){
            System.out.println("El dato introducido no es correcto, vuelva a empezar");
        }else
        //Pedimos el número de contagiados 
        System.out.println("Introduce el número de contagios en la población las últimas dos semanas por favor");
        //recogemos el número por escaner
        Double contagios = sc.nextDouble();
        //Realizamos la fórmula
        Double tasa = (contagios / habitantes) * 100000;
        //Condición si se cumple la tasa superior a 200
        if (tasa >=200){
        System.out.println("\nA partir de los 200 contagios en tasa se recomienda confinamiento.");
        }
        //Mostramos la tasa por consola
        System.out.printf("La tasa de contagios es: %.3f", tasa);
    }

}
