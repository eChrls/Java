package PaqueteDados;

import java.util.Random;

public class metodosJuego {

    /*1 array             para guardar si el jugador gana o pierde la ronda*/
    private static int[] resultadosRondas = new int[15]; 
    /*1 array             para almacenar el número de veces que se han tirado los dados en la ronda. */  
    private static int[] tiradasRondas = new int[15];
    
    /*tirarDados(),       tira los dados, calcula la suma, devuelve esta suma y muestra los resultados por pantalla. 
                          Este método será privado y se llamará desde el método jugar(). tirarDados() no tiene parámetros.*/
    private static int tirarDados() {
        int resultado = 0;
        int dado1, dado2, dado3;
        Random random = new Random();

        dado1 = random.nextInt(1, 7);
        dado2 = random.nextInt(1, 7);
        dado3 = random.nextInt(1, 7);
        resultado = dado1 + dado2 + dado3;

        return resultado;
    }

    /*   tiradasTotales(),   que devolverá el número total de tiradas almacenadas en el array que guarda las tiradas en cada ronda. 
                             No tiene parámetros.*/
    public static int tiradasTotales() {
      int totalTiradas = 0;
      for(int tiradas : tiradasRondas){
          totalTiradas += tiradas; 
      }
      return totalTiradas; 
    }

    /*    numeroVictorias(),  que devolverá el número de rondas que ha ganado el jugador. No tiene parámetros.*/
    public static int numeroVictorias() {
        int victorias = 0;
        for (int resultado : resultadosRondas){
            if (resultado == 1){
                victorias++;
            }
        }     
        return victorias;
    }
    /*    jugar(),         que implementará la lógica del juego. Este método irá informando por consola de todos los pasos que se van 
                        realizando en el juego. Al finalizar todas las jugadas debe informar si gana el jugador o la banca. 
                        No devuelve nada, no recibe nada y es público*/
    public static void jugar() {
        int resultadoObjetivo = 0;
        int contador = 0;
        int victorias = 0;
        int derrotas = 0;
        int rondas = 0;
        int vecesQueSeTiraElDado = 0; 

        do {
            int resultadoPrimertiro = metodosJuego.tirarDados();
            tiradasRondas[rondas]++;
            System.out.println("El resultado del primer tiro es " + resultadoPrimertiro);
            if (resultadoPrimertiro == 9 || resultadoPrimertiro == 13) {
                System.out.println("Enhorabuena, has ganado la ronda " + contador + ",  ha salido el número " + resultadoPrimertiro);
                resultadosRondas[rondas] = 1; //1 indica la victoria en el array, sí se contará
                victorias++;
                vecesQueSeTiraElDado++;
            } else if (resultadoPrimertiro == 3 || resultadoPrimertiro == 7 || resultadoPrimertiro == 19) {
                System.out.println("Lo siento, has perdido la ronda " + contador + ", ha salido el número " + resultadoPrimertiro);
                derrotas++;
                resultadosRondas[rondas] = - 1; //- 1 indica la derrota en el array, no se cont
                vecesQueSeTiraElDado++;
            } else {
                resultadoObjetivo = resultadoPrimertiro;
                vecesQueSeTiraElDado++;
                System.out.println("El resultado objetivo para ganar en la ronda " + contador + " es " + resultadoObjetivo + ". Cuidado, si sumas 7 pierdes.");
            }

            int resultado;
            do {
                resultado = metodosJuego.tirarDados();
                if (resultado == resultadoObjetivo) {
                    System.out.println("Enhorabuena, has ganado la ronda nº " + contador + ",  ha salido el número " + resultado);
                    resultadosRondas[rondas] = 1; //1 indica la victoria en el array, sí se contará
                    victorias++;
                    vecesQueSeTiraElDado++;
                } else if (resultado == 7) {
                    System.out.println("Enhorabuena, has ganado la ronda nº " + contador + ",  ha salido el número " + resultado);
                    derrotas++;
                    resultadosRondas[rondas] = - 1; //- 1 indica la derrota en el array, no se contará
                    vecesQueSeTiraElDado++;
                }

            } while (resultado != 7 && resultado != resultadoObjetivo);
            rondas++;
        } while (rondas < 15);
        System.out.println("Has jugado " + tiradasTotales() + " rondas. " + "\n" + "Has ganado " + victorias + " rondas. " + "\n" + "Has perdido " + derrotas + " rondas. " + "\n" +
                "Se han necesitado " + vecesQueSeTiraElDado + " tiradas. ");

    }

}
