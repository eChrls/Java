package JuegoAhorcado;

import javax.swing.*;
import java.util.*;

public class JuegoAhorcado {

    //METODO
    //MAIN
    public static void main(String[] args) {

        int contadorVidas = 0;
        int numeroMenu = 0;
        String palabraAleatoria = "";
        Scanner scn = new Scanner(System.in);
        int comparar = 1;
        ArrayList<Character> abecedario = new ArrayList<>(27);
        ArrayList<Character> elegidas = new ArrayList<>();
        metodosGenerales.llenarAbecedario(abecedario);

        char ahorcado[];
        //letra no existe por ahora
        char letra = ' ';

        do {
            int vidas = 7; //vidas dentro del bucle, para llenar contador en segunda partida. 
            elegidas.clear(); // Limpiar letras elegidas.
            abecedario.clear(); // Limpiar abecedario y volver a llenarlo.
            metodosGenerales.llenarAbecedario(abecedario);

            numeroMenu = metodosGenerales.mostrarMenu();
            switch (numeroMenu) {
                case 1 -> {
                    metodosGenerales.primerMenu();
                    JOptionPane.showConfirmDialog(null, "En mantenimiento. Pronto Disponible.");
                }
                case 2 -> {
                    //Elegimos palabra aleatoria                     
                    palabraAleatoria = metodosGenerales.elegirPalabraAleatoria();
                    //Convertimos palabra aleatoria a char[]ahorcado 
                    ahorcado = new char[palabraAleatoria.length()];
                    //Convertimos palabra a rayitas ---- 
                    metodosGenerales.llenarAhorcado(ahorcado, palabraAleatoria);
                    metodosGenerales.mostrarArray(ahorcado);//da espacios entre posiciones
                    //creamos lista abecedario
                    metodosGenerales.llenarAbecedario(abecedario);
                    //muestra el menu que explica las vidas
                    metodosGenerales.primerMenu();
                    //iniciamos bucle jugable del caso 2
                    //char vocal = anadirVocal()
                    //metodosGenerales.añadirLetra(vocal, ahorcado, palabraAleatoria);
                    do {
                        //añadimos a letra la letra escaneada con elegirLetra (que filtra si es letra)
                        letra = metodosGenerales.elegirLetra();
                        //comprobamos 3 escenarios para la letra 
                        //1- la has elegido anteriormente
                        //2- la has acertado
                        //3- la has fallado
                        metodosGenerales.comprobarLetra(elegidas, palabraAleatoria, letra);
                        switch (metodosGenerales.comprobarLetra(elegidas, palabraAleatoria, letra)) {
                            case 1 -> {
                                System.out.println("Has usado la letra anteriormente, vuelve a intentarlo");
                            }
                            case 2 -> {
                                System.out.println("Has acertado la letra");
                                //Añadimos a la lista elegidas la letra elegida anteriormente
                                elegidas.add(letra);
                                //BORRAMOS LETRA CON CASTING CHARACTER
                                abecedario.remove((Character) letra);
                                //añade letra al ahorcado
                                metodosGenerales.añadirLetra(letra, ahorcado, palabraAleatoria);
                            }
                            case 3 -> {
                                System.out.println("Has fallado la letra");
                                //Añadimos a la lista elegidas la letra elegida anteriormente
                                elegidas.add(letra);
                                //BORRAMOS LETRA CON CASTING CHARACTER
                                abecedario.remove((Character) letra);
                                //al haber fallado resta una vida
                                vidas--;
                                //metodo para mostrar el muñeco con las vidas que llevas
                                metodosGenerales.restarVidas(vidas);
                            }
                        }
                        //Lista para las letras restantes
                        ArrayList<Character> abecedarioRestante = new ArrayList<>(abecedario);
                        abecedarioRestante.removeAll(elegidas);

                        //menu para ver el estado del juego despues de recorrer el juego
                        String estadoJuego = "La palabra a adivinar es: " + metodosGenerales.mostrarArray(ahorcado) + "\n "
                                + "has elegido las siguientes letras =" + elegidas + "\n " + " y te quedan:  =" + abecedarioRestante + "\n"
                                + "Te quedan las siguientes vidas = " + vidas;
                        JOptionPane.showMessageDialog(null, estadoJuego);

                        if (vidas <= 0) {
                            JOptionPane.showMessageDialog(null, "¡Juego terminado! No te quedan vidas.");
                            break;
                        }

                        if (metodosGenerales.compararPalabras(ahorcado, palabraAleatoria) == 1) {
                            JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado la palabra: " + palabraAleatoria);
                            break;
                        }
                        //bucle while para volver o salir dependiendo de si la palabra esta acertada o las vidas se agotan
                    } while (vidas > 0 && metodosGenerales.compararPalabras(ahorcado, palabraAleatoria) != 1);
                }
                case 3 -> {

                    System.out.println("Gracias por jugar");

                }

                default -> {
                    System.out.println("Opción incorrecta");
                }
            }

        } while (numeroMenu != 3);

    }
}
/*COSAS ARREGLADAS CON CHAT GPT
- Problema con abecedario repetido por mensaje. SOLUCION : creación de lista abecedarioRestante y usar removeall.
Yo estaba combinando abecedario.removeall(elegidas) y me devolvía true por mensaje. 
- Problema con bucle final del caso 2. Tenia puesto || y así no funcionaba bien. Tenia vidas negativas. SOLUCIÓN usar AND. 
- Problema con letras usadas y abecedario en segudas partidas. Se quedaban guardadas. SOLUCIÓN: Usar funciones .clear : 
    elegidas.clear(); // Limpiar letras elegidas.
    abecedario.clear(); // Limpiar abecedario y volver a llenarlo.
    metodosGenerales.llenarAbecedario(abecedario);

COSAS ARREGLADAS CON ALEJANDRO: 
- Reestructuración de métodos y nombres. 
- Creación del método comprobarLetra desde 0, sustituyendo el que tenía, distribuyendo los algoritmos del juego 
en tres posibles soluciones.

  
public static int comprobarLetra(ArrayList<Character> elegidas, String palabraAleatoria, char letra) {
        //ESCENARIO 1 . HAS USADO LA LETRA ANTERIORMENTE
        for (char c : elegidas) {
            if (c == letra) {
                return 1;
            }//comprueba si has usado la letra en elegidas
        }
        //ESCENARIO 2 , ACIERTA LA LETRA
        for (int i = 0; i < palabraAleatoria.length(); i++) {
            if (palabraAleatoria.charAt(i) == letra) {
                return 2;
            }
        }//actualiza palabra y listas en el main
        //ESCENARIO 3. FALLAS LA LETRA ELEGIDA Y RESTA VIDA.
        return 3;
        //para pierdes una vida y se actualiza la lista no la palabra (en el main)
    }

- Orden y estructura de los métodos en el main. 
        - Estaba usando los métodos sin descargar el valor. 
        - Estaba colocando los métodos en el orden y lugar equivocados. 


COSAS POR COMPLETAR DEL EJERCICIO
- Introducción de vocal automáticamente al inicio del juego sobre la palabra elegida, en todas las posiciones que esté
y solamente una vocal. 
- Desarrollar el método de 1 vs 1. Opción 1 del juego. 
- Usar git branch, merge, etc..


 */
