/*Cuando tengamos el string, transformarlo en array de char
y el algoritmo tiene que recorrer el array de inicio a fin,
comparar las letras de inicio a fin, comparando primero con 
ultimo y si son iguales, que uno avance y otro retroceda, 
hasta que podamos saber que se cumple la condicion si es palindromo*/
package EstructurasDeAlmacenamiento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Palindromo {

public static void main(String[] args) {

    // pedimos el string
    String palindromo = JOptionPane.showInputDialog("Introduce la palabra para saber si es palindromo: ");

    // Código antiguo:
    // char[] pal = palindromo.toCharArray();
    // ArrayList<Character> lista = new ArrayList<>();
    // for (int i = 0; i < pal.length; i++) {
    //     lista.add(pal[i]);
    // }
    // System.out.println(lista);
    // System.out.println(pal);
    // if (lista.equals(palindromo)){
    //     System.out.println("Es palíndromo");
    // }else{
    //     System.out.println("No es palindromo");
    // }

    // Código corregido:
         // Usamos dos índices para recorrer directamente el String
        boolean esPalindromo = true;
        for (int i = 0, j = palindromo.length() - 1; i < j; i++, j--) {
            if (palindromo.charAt(i) != palindromo.charAt(j)) { // Comparamos los caracteres directamente
                esPalindromo = false;
                break;
            }
        }

        // Mostramos el resultado
        if (esPalindromo) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }






}
}


