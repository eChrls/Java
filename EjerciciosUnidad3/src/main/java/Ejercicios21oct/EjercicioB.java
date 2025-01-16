/*B. Pirámide de números. Genera un pirámide de números como esta.
1
22
333
4444
55555
666666
...
La pirámide tendrá tantos pisos como decida el usuario, de 1 a 10.*/
package Ejercicios21oct;

import java.util.*;

public class EjercicioB {
    public static void main(String[] args) {
     
        Scanner s = new Scanner (System.in);
        
        System.out.println("Introduce el numero de 1 a 10 para hacer una pirámide de esa altura: ");
        
        int altura = s.nextInt();
        
        if (altura < 1 || altura > 10){
            System.out.println("Altura introducida incorrecta, vuelva a empezar e introduzca un nº del 1 al 10");
            
            }else{
                for (int i = 1; i <= altura; i++) {
                    for( int j = 1; j <= i; j++){
                        System.out.print(i);                               
                    }//aqui el bucle for doble consiste en que la j tendrá el mismo recorrido que el valor de i
                    //y i tendrá el mismo recorrido que la altura. Cada vez que j recorre una i imprime pantalla. Hasta que acabe el total de i.
                    System.out.println();
            }
        }     
    }
}

