package PaqueteDados;

public class JuegoDados {

    /*
PARTE A
    3 dados - 6 caras ( 1- 6) -> se suman 
        -> si sale 9 o 13 en el primer tiro -> el jugador gana
        -> si sale 3, 7, o 18 en el primer tiro -> el jugador pierde
    -> si sale otro número, 
        -> ese número tiene que repetirlo para ganar o sacar un 7 para perder. 
    
PARTE B
    REPETIR LA PARTE A DURANTE 15 RONDAS
        - Resultado de victorias/derrotas
        - Nº de veces que se tiraron los dados en cada ronda
        - El jugador gana si    
            -> ha ganado 8 rondas
            -> ha ganado 7 con un nº de tiradas total menor que 30.
    
    A USAR
    
    1 array             para guardar si el jugador gana o pierde la ronda
    
    1 array             para almacenar el número de veces que se han tirado los dados en la ronda.
    
    tirarDados(),       tira los dados, calcula la suma, devuelve esta suma y muestra los resultados por pantalla. 
                        Este método será privado y se llamará desde el método jugar(). tirarDados() no tiene parámetros.
    
    tiradasTotales(),   que devolverá el número total de tiradas almacenadas en el array que guarda las tiradas en cada ronda. 
                        No tiene parámetros.
    
    numeroVictorias(),  que devolverá el número de rondas que ha ganado el jugador. No tiene parámetros.
    
    jugar(),            que implementará la lógica del juego. Este método irá informando por consola de todos los pasos que se van 
                        realizando en el juego. Al finalizar todas las jugadas debe informar si gana el jugador o la banca. 
                        No devuelve nada, no recibe nada y es público.
     */
    public static void main(String[] args) {
        int resultadoObjetivo = 0;
        int contador = 0;
        int victorias = 0;
        int derrotas = 0;
        int rondas = 0;

        metodosJuego.jugar();
        
    }
}
