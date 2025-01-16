/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package PaqueteJuegoDedos;

/**
 *
 * @author Casa
 */
public class JuegoDedos {

    public static void main(String[] args) {
    
        int player1 = 0; 
        int player2 = 0;
        
        int contador = 1;
        System.out.println("Bienvenido al juego de Suma de Dedos. Participan Variable y Primitivo.\n El primero que sume dos victorias sobre el rival acertando la suma de los dedos gana.");
        do {            
            
       int primeraApuesta = MetodosDelJuego.primeraApuesta();
       System.out.println("NUEVA PARTIDA.\n Empieza Variable. Variable apuesta que van a sumar " + primeraApuesta);
       int segundaApuesta = MetodosDelJuego.segundaApuesta(primeraApuesta);
       System.out.println("Primitivo apuesta que van a sumar " + segundaApuesta);
            System.out.println("Entramos en la fase de enseñar los dedos: ");
            int dedosP1 = MetodosDelJuego.dedosP1(primeraApuesta);
            System.out.println("Variable elige sacar " + dedosP1 + " dedos");
            int dedosP2 = MetodosDelJuego.dedosP1(primeraApuesta);
            System.out.println("Primitivo elige sacar " + dedosP2 + " dedos");
            int sumaDedos = MetodosDelJuego.sumaDedos(dedosP1, dedosP2);
            int resultado = MetodosDelJuego.resultados(sumaDedos, primeraApuesta, segundaApuesta);
            switch (resultado){
                case 1 ->{
                    player1++; 
                   System.out.println("Ganó Variable. El resultado de la ronda nº " + contador + " es  = " + primeraApuesta); 
                }
                case 2 ->{
                  System.out.println("Ganó Primitivo. El resultado de la ronda nº " + contador + " es  = " + segundaApuesta);  
                  player2++;
                }
                case 3 ->{
                    System.out.println("No acertó nadie, volvemos a empezar.");
                }
            }
            System.out.println("Recuento: \n Ronda nº " + contador + "\n Variable = " + player1 + " puntos. "
            + "\n Primitivo = " + player2 + " puntos.");
            contador++;
          
       } while (player1 != (player2 + 2) && player1 !=(player2 - 2));
        if(player1 == (player2 + 2)){
            System.out.println("HA GANADO VARIABLE");
        }
        if(player1 == (player2 - 2)){
            System.out.println("HA GANADO PRIMITIVO");
        }
        
    }
}
