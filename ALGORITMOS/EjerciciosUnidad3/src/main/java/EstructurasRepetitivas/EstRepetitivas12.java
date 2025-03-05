/*12. Implementa un algoritmo que permite jugar con el ordenador a acertar números. 
La máquina pensará un número aleatorio entre 10 y 20. El jugador tendrá tres intentos para 
adivinarlo. El ordenador irá ayudando al jugador indicando si el número introducido por el 
jugador es mayor o menor al pensado. Si adivina el número se mostrará un mensaje de 
enhorabuena y si no entonces se mostrará el número pensado. Una vez finaliza la partida 
la máquina preguntará si se quiere jugar otra vez, si respondemos “sí” volverá a empezar 
y si no queremos jugar más escribiremos “no”. En caso de escribir otra cosa el programa 
avisará al usuario para que escriba una opción correcta.
 */
package EstructurasRepetitivas;

import java.util.*;

public class EstRepetitivas12 {
    
    public static void main(String[] args) {
        Random r = new Random();
        Scanner n = new Scanner(System.in);
        String progFinal = " ";
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        //nombramos todas las variables fuera del bucle. los 3 numeros, la respuesta final, el scanner y el random
        //bucle do while
        do {
            int random = r.nextInt(10, 21);//random entre 10 y 21 = a 10 y 20
            System.out.println("Introduce tres números para adivinar el número entre 10 y 20");
            num1 = n.nextInt();
            //primer intento, estructura if y else if
            if (num1 == random) {
                System.out.println("Enhorabuena has acertado a la primera");
            } else if (num1 < random) {
                System.out.println("Es un número más grande");
            } else if (num1 > random) {
                System.out.println("Es un número más pequeño");
            } 
                System.out.println("Introduce el segundo número");
                //segundo intento
                num2 = n.nextInt();
                
                if (num2 == random) {
                    System.out.println("Enhorabuena has acertado a la segunda");
                } else if (num2 < random) {
                    System.out.println("Es un número más grande");
                } else if (num2 > random) {
                    System.out.println("Es un número más pequeño");
                } 
                    System.out.println("Introduce el tercer número");
                    //tercer intento
                    num3 = n.nextInt();

                    if (num3 == random) {//ya solo puede ser acierto o error
                        System.out.println("Enhorabuena, has acertado a la tercera");
                    } else if (num3 != random) {
                        System.out.println("Lo siento, no has acertado, el número era el " + random);
                    }
                    n.nextLine();//limpiamos la memoria del next
                    System.out.println ( "Introduce tu respuesta. Quieres volver a jugar [si] [no]");//menu para volver a empezar
                    progFinal = n.nextLine().toLowerCase();
            }while(progFinal.equals("si"));
                    
            System.out.println("Gracias por jugar");
     
    } 
}
            
            

      



