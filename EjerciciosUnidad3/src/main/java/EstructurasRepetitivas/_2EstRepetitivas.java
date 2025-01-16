//2. Sumar los 10 primeros números enteros, usando las tres estructuras repetitivas.
package EstructurasRepetitivas;

public class _2EstRepetitivas {

    public static void main(String[] args) {

//COMIENZO BUCLE FOR
//Inicializamos total para que funcione en for
        int totalFOR = 0;
//bucle for con formula clasica y total+i
        for (int i = 1; i <= 10; i++) {
            totalFOR = totalFOR + i;
        }
        System.out.println(totalFOR);
//COMIENZO BUCLE WHILE        
//Inicializamos total e i
        int totalW = 0;
        int x = 0;
//bucle while hasta 10 con i++ y misma formula que antes
        while (x < 10) {
            x++;
            totalW = totalW + x;
        }
        System.out.println(totalW);
//COMIENZO BUCLE DO WHILE        
//Inicializamos variables
        int totalDoWh = 0;
        int j = 0;
//DO para las instrucciones
        do {
            j++;
            totalDoWh = totalDoWh + j;
//WHILE para las condiciones
        } while (j < 10);
        System.out.println(totalDoWh);
    }
}
