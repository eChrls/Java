/*1. Algoritmo que lea una variable entera mes y compruebe si el valor corresponde a un mes 
de 30, 31 o 28 días. Se mostrará además el nombre del mes. Se debe comprobar que el valor 
introducido esté comprendido entre 1 y 12. En caso contrario se solicitará 
de nuevo el dato mes.*/
package EstructurasRepetitivas;

import java.util.*;

public class _1EstRepetitivas {
    public static void main(String[] args) {
        
    Scanner sc1 = new Scanner(System.in);
    //declaro mes para que entre en el while
    int mes;

    //condicion DO para introducción y WHILE para determinar campo de trabajo    
    
        do{
        System.out.println("Introduce el mes para saber los días (1-12): ");

        mes = sc1.nextInt();

    }
    while (mes <= 0 || mes >=13);
    //SWITCH clasificando a los meses en grupos por dias.
    switch (mes) {
        case 4, 6, 9, 11:
            System.out.println("El mes tiene 30 días");
            break;
        case 1, 3, 7, 8, 10, 12:
            System.out.println("El mes tiene 31 días");
            break;
        default:
            System.out.println("El mes tiene 28 días");
    }
}
}