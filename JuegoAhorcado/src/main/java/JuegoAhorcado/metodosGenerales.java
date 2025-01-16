package JuegoAhorcado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class metodosGenerales {

    //FALTA HACER EL TRY CATCH 
    //DEVUELVE EL VALOR DEL SWITCH
    public static int mostrarMenu() {
        int numeroMenu;
        do {
            //Posible excepcion NumberFormatException en JOptionPane si entran caracteres               
            //Ponemos el código susceptible de error en un try catch
            try {
                String menu = """
                      Bienvenido al juego del ahorcado.
                      Elija una opcion (1-3) : 
                        1.  MODO 2 JUGADORES
                        2.  MODO VS LA MAQUINA
                        3.  SALIR
                      
                      """;

                String strNumeroMenu = JOptionPane.showInputDialog(menu);
                numeroMenu = Integer.parseInt(strNumeroMenu);
                break;
            } catch (NumberFormatException nfe) {
                //Aqui dentro pongo el codigo para recupearme del error
                JOptionPane.showConfirmDialog(null, "No has introducido un numero, vuelve a intentarlo.");
            }
        } while (true);

        return numeroMenu;
    }

    //METODO PARA SABER SI ES LETRA
    public static boolean esLetra(char letra) {
        //con la funcion isLetter mejoro el descarte por numeros. 
        return Character.isLetter(letra);

        /*   if (letra == ('0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9')) {
                return false;
            }
         return true;*/
    }

    public static void llenarAbecedario(ArrayList<Character> abecedario) {

        // Llenar el array con las letras del abecedario
        for (int i = 0; i < 26; i++) {
            abecedario.add((char) ('a' + i)); // Esto asigna las letras de la 'a' a la 'z'
        }
        // Si quieres añadir la letra 'ñ', la puedes agregar al final
        abecedario.add('ñ');

    }
    //Se usa cada vez que se pide letra y te filtra si es una letra

    public static char elegirLetra() {
        Scanner scn = new Scanner(System.in);
        char letra;
        do {
            System.out.println("Introduce la letra que quieras probar: ");
            String letraString = scn.nextLine();
            letra = letraString.charAt(0);
            metodosGenerales.esLetra(letra);
        } while (false);
        return letra;
    }

    //METODO PARA MOSTRAR EL ARRAY MAS LEGIBLEMENTE
    //SE USA CADA VEZ SE MUESTRE UN ARRAY AL USUARIO
    public static String mostrarArray(char[] array) {
        String palabraLegible = "";

        for (int i = 0; i < array.length; i++) {
            palabraLegible += array[i];
            palabraLegible += " ";

        }
        return palabraLegible;
    }

    //METODO PARA AÑADIR LETRA A LA PALABRA AHORCADO SI ESTA INCLUIDA
    //Pedimos letra con metodo elegir letra que filtra si es una letra tambien
    public static void añadirLetra(char letra, char[] ahorcado, String palabraAleatoria) {

        for (int i = 0; i < palabraAleatoria.length(); i++) {
            if (palabraAleatoria.charAt(i) == letra) {
                ahorcado[i] = letra;
            }
        }
    }
    //METODO QUE COGE ALEATORIAMENTE POR POSICION DE UN ARRAY UNA PALABRA ALEATORIA PARA EL JUEGO VS LA MAQUINA

    public static String elegirPalabraAleatoria() {
        Random random = new Random();
        int aleatorio = 0;

        String[] palabras = {"programar", "diseñar", "analizar", "algoritmo", "dato", "código", "computadora", "interfaz", "proceso", "sistema", "variable", "archivo"};
        //ArrayList<String> listaPalabras = new ArrayList<>(Arrays.asList("programar", "diseñar", "analizar", "algoritmo", "dato", "código", "computadora", "interfaz", "proceso", "sistema", "variable", "archivo"));
        aleatorio = random.nextInt(palabras.length);

        /* for (int i = 0; i < palabras.length - 1; i++) {
                if (aleatorio == i){*/
        String palabraAleatoria = palabras[aleatorio];

        return palabraAleatoria;
    }

    //Metodo para convertir palabra aleatoria en un char[] de  -----
    public static void llenarAhorcado(char[] ahorcado, String palabraAleatoria) {
        //do while hasta que encuentre la vocal. 
        for (int i = 0; i < palabraAleatoria.length(); i++) {

            ahorcado[i] = '-';
        }
    }//una vez localizada y añadida la vocal llamo al metodo

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

    //METODO PARA MOSTRAR GRAFICO Y CONTAR LAS VIDASñ
    public static void restarVidas(int vidas) {

        switch (vidas) {
            case 0 -> {
                String texto = ("""
                                AHORCADO! 
                                   _________ 
                                   |        |
                                   |        **
                                   |        **
                                   |   **** * *****
                                   |        *
                                   |        *
                                   |       * *
                                   |      *   *
                                ---|----
                                
                                   """);
               String menu =  JOptionPane.showInputDialog(texto);
            }

            case 1 -> {
                String texto = ("""
                                Te queda 1 intento
                                   _________ 
                                   |        |
                                   |        **
                                   |        **
                                   |   **** * *****
                                   |        *
                                   |        *
                                   |       * 
                                   |      *   
                                ---|----
                                
                                   """);
            }
            case 2 -> {
                String texto = ("""
                                Te quedan 2 intentos
                                   _________ 
                                   |        |
                                   |        **
                                   |        **
                                   |   **** * *****
                                   |        *
                                   |        *
                                   |       
                                   |         
                                ---|----
                                
                                   """);
                System.out.println(texto);
            }
            case 3 -> {
                String texto = ("""
                                Te quedan 3 intentos
                                   _________ 
                                   |        |
                                   |        **
                                   |        **
                                   |   **** *
                                   |        *
                                   |        *
                                   |       
                                   |         
                                ---|----
                                
                                   """);
                System.out.println(texto);
            }
            case 4 -> {
                String texto = ("""
                                Te quedan 4 intentos
                                   _________ 
                                   |        |
                                   |        **
                                   |        **
                                   |        *    
                                   |        *
                                   |        *
                                   |       
                                   |         
                                ---|----
                                
                                   """);
                System.out.println(texto);
            }
            case 5 -> {
                String texto = ("""
                                Te quedan 5 intentos
                                   _________ 
                                   |        |
                                   |        **
                                   |        **
                                   |          
                                   |        
                                   |        
                                   |       
                                   |         
                                ---|----
                                
                                   """);
                System.out.println(texto);
            }
            case 6 -> {
                String texto = ("""
                                Te quedan 6 intentos
                                   _________ 
                                   |        |
                                   |        
                                   |        
                                   |          
                                   |        
                                   |        
                                   |       
                                   |         
                                ---|----
                                
                                   """);
                System.out.println(texto);
            }
        }
    }

    public static void primerMenu() {
        String texto = ("""
                                Empiezas con 7 intentos
                                 _________ 
                                |        
                                |        
                                |        
                                |          
                                |        
                                |        
                                |       
                                |  
                             ---|----
                                
                                   """);
        JOptionPane.showMessageDialog(null, texto);
    }

    //Metodo para comparar los arrays de chars y si es false se repita el bucle
    public static int compararPalabras(char[] ahorcado, String palabraAleatoria) {
        String ahorcadoString = new String(ahorcado);

        if (ahorcadoString.equalsIgnoreCase(palabraAleatoria)) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
