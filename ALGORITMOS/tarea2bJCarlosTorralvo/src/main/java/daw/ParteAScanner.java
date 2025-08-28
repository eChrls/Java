/** PARTE A
 * Crea una clase llamada ParteAScanner. Solicita al usuario los datos necesarios para calcular la tasa de contagios de una población.
 * Estos datos se solicitan usando la clase Scanner. Se supone que siempre se calcula sobre las dos semanas anteriores a la fecha
 * en la que se está ejecutando el programa.
 * Realiza los cálculos pertinentes y almacena los resultados en variables del tipo de dato apropiado.
 * Muestra los resultados usando la salida estándar (System.out). Debes usar los métodos println y printf,
 * para limitar con tres decimales la salida numérica. */
package daw;

import java.util.Scanner;

public class ParteAScanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Pedimos el número de contagiados 
        System.out.println("Introduce el número de contagios en la población las últimas dos semanas por favor");
        //recogemos el número por escaner
        Double contagios = sc.nextDouble();
        //Realizamos la fórmula
        int habitantesEst = 75000;
        Double tasa = (contagios / habitantesEst) * 100000;
        //Mostramos la tasa por consola
        System.out.printf("La tasa de contagios en Estepona es: %.3f", tasa); 
        System.out.println("\nA partir de los 500 contagios se recomienda confinamiento.");               
    }
}
