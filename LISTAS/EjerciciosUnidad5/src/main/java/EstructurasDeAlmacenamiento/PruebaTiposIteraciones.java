
package EstructurasDeAlmacenamiento;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class PruebaTiposIteraciones {
    
    public static void main(String[] args) {
      long primo = 3_000_000_019L;
      LocalDateTime inicio = LocalDateTime.now();
      
      System.out.println(inicio);
      System.out.println("Es primo? " + esPrimoMejorado(primo));
        LocalDateTime fin = LocalDateTime.now();
        long diferencia = ChronoUnit.SECONDS.between(inicio, fin);
        System.out.println("TIEMPO EMPLEADO " + diferencia + " segundos");
        
    }
    /*
    //algoritmo basico de fuerza bruta para ver los primos
    //dividimos por todos los numeros excepto 1 y el mismo. 
    public static boolean esPrimoBasico(long numero){
        long ultimo = 0;
        
        for (long i = 2; i < numero; i++) {
            if(numero % i == 0){
                return false;
            }               
        }System.out.println("Ultimo numero revisado " + ultimo);
        return true;
        */
    
    public static boolean esPrimoMejorado(long numero){
       long ultimo = 0;
        if(numero % 2 == 0){
            return false;
        }
        
            for (long i = 3; i <= numero/2; i+=2) {
                if(numero % i == 0){
                    return false;
            }   
                ultimo = i;
        }System.out.println("Ultimo numero revisado " + ultimo);
        return true;
        

    }   
}
