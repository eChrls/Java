package PaqueteJuegoDedos;

import static java.lang.Math.random;
import java.util.Random;

public class MetodosDelJuego {

    /*PUNTUACIÓN MÍNIMA = 2
  PUNTUACIÓN MÁXIMA = 10
  VALOR JUGADOR MINIMO = 1
  VALOR JUGADOR MÁXIMO = 5
  
  Es decir.
  APUESTA JUGADOR 1 = X 
  APUESTA MAXIMA JUGADOR 2 = X + 5
  APUESTA MINIMA JUGADOR 2 = X - 1
  APUESTA JUGADOR 2 != X 
     */
    public static int primeraApuesta() {
        Random random = new Random();

        int primeraApuesta = random.nextInt(3, 10);//OMITO EL 2 Y EL 10 POR UNA SOLA POSIBILIDAD PARA CUMPLIRSE

        
        return primeraApuesta;
    }

    public static int segundaApuesta(int primeraApuesta) {
        Random random = new Random();
        int segundaApuesta;
        int dedos = 0;

        if (primeraApuesta == 9) {
            dedos = random.nextInt(4, 6); //ELIGE 4 O 5
        }
        if (primeraApuesta == 8) {
            dedos = random.nextInt(3, 6);//ELIGE 3, 4 O 5    
        }
        if (primeraApuesta == 7) {
            dedos = random.nextInt(2, 6);//ELIGE 2, 3, 4 O 5  
        }
        if (primeraApuesta == 6) {
            dedos = random.nextInt(1, 6);//ELIGE 1, 2, 3, 4 O 5  
        }
        if (primeraApuesta == 5) {
            dedos = random.nextInt(1, 5);//ELIGE 1, 2, 3, 4  
        }
        if (primeraApuesta == 4) {
            dedos = random.nextInt(1, 4);//ELIGE 1, 2, 3 
        }
        if (primeraApuesta == 3) {
            dedos = random.nextInt(1, 3);//ELIGE 1 Y 2
        }
        
        do {            

        segundaApuesta = dedos * 2;
                    
        } while (segundaApuesta == primeraApuesta);
        
        return segundaApuesta;
    }
    
    public static int dedosP1 (int primeraApuesta){
        Random random = new Random();
        int dedosP1 = 0; 
        
        if (primeraApuesta == 9) {
            dedosP1 = random.nextInt(4, 6); //ELIGE 4 O 5
        }
        if (primeraApuesta == 8) {
            dedosP1 = random.nextInt(3, 6);//ELIGE 3, 4 O 5    
        }
        if (primeraApuesta == 7) {
            dedosP1 = random.nextInt(2, 6);//ELIGE 2, 3, 4 O 5  
        }
        if (primeraApuesta == 6) {
            dedosP1 = random.nextInt(1, 6);//ELIGE 1, 2, 3, 4 O 5  
        }
        if (primeraApuesta == 5) {
            dedosP1 = random.nextInt(1, 5);//ELIGE 1, 2, 3, 4  
        }
        if (primeraApuesta == 4) {
            dedosP1 = random.nextInt(1, 4);//ELIGE 1, 2, 3 
        }
        if (primeraApuesta == 3) {
            dedosP1 = random.nextInt(1, 3);//ELIGE 1 Y 2
        }
        
        return dedosP1; 
    }
    
    public static int dedosP2 (int primeraApuesta){
        Random random = new Random();
        int dedosP2 = 0; 
        
        if (primeraApuesta == 9) {
            dedosP2 = random.nextInt(4, 6); //ELIGE 4 O 5
        }
        if (primeraApuesta == 8) {
            dedosP2 = random.nextInt(3, 6);//ELIGE 3, 4 O 5    
        }
        if (primeraApuesta == 7) {
            dedosP2 = random.nextInt(2, 6);//ELIGE 2, 3, 4 O 5  
        }
        if (primeraApuesta == 6) {
            dedosP2 = random.nextInt(1, 6);//ELIGE 1, 2, 3, 4 O 5  
        }
        if (primeraApuesta == 5) {
            dedosP2 = random.nextInt(1, 5);//ELIGE 1, 2, 3, 4  
        }
        if (primeraApuesta == 4) {
            dedosP2 = random.nextInt(1, 4);//ELIGE 1, 2, 3 
        }
        if (primeraApuesta == 3) {
            dedosP2 = random.nextInt(1, 3);//ELIGE 1 Y 2
        }
        return dedosP2; 
    }
    
    public static int sumaDedos (int dedosP1, int dedosP2){       
        
        return dedosP1 + dedosP2;
    }
    
    public static int resultados (int sumaDedos, int primeraApuesta, int segundaApuesta){
        
        if (sumaDedos == primeraApuesta){
            return 1;
        }
        else if ( sumaDedos == segundaApuesta){
            return 2; 
        }
        else
            return 3; 
    }
    
    
    
    
}



   
 
