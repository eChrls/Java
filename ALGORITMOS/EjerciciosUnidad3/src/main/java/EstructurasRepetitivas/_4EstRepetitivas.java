//4. Elabora un algoritmo para que lea tantos números 
//como queramos hasta que llegue un número 0 y muestre la suma de todos ellos.
package EstructurasRepetitivas;

import java.util.*;

public class _4EstRepetitivas {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
//Inicializamos variables fuera del bucle
    int num = 0;
    int total = 0;
//Instrucciones del DO, dar mensaje, recoger datos y sumarlos. 
        do { System.out.println("Introduce un numero entero. Cuando pulse 0 se sumaran todos");
        num = sc.nextInt();
        total = total + num;
//Condicion WHILE que no sea 0
    }
    while (num!= 0);
    System.out.println (

"La suma total de los numeros es "+ total);
}          
}
