package EjerciciosNavidad;

import javax.swing.JOptionPane;

public class Palindromo {

    public static void main(String[] args) {

        String palabra = JOptionPane.showInputDialog("Introduce la palabra para comprobar si es palíndromo: ");
        boolean esPalindromo = true;
        for (int i = 0; i < palabra.length() - 1 / 2; i++) {
            for (int j = palabra.length() - 1; j > palabra.length() - 1 / 2; j--) {
                if (palabra.charAt(i) != palabra.charAt(j)) {
                    esPalindromo = false;
                      break;
                }
            }
        }
        if (esPalindromo) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
            /*CORRECTO (fallo en el for) */
//        String palindromo = JOptionPane.showInputDialog("Introduce la palabra para comprobar si es palíndromo: ");
//        boolean esPalindromo = true;
//        for (int i = 0, j = palindromo.length() - 1; i < j; i++, j--) {
//            if (palindromo.charAt(i) != palindromo.charAt(j)) { // Comparamos los caracteres directamente
//                esPalindromo = false;
//                break;
//            }
//        }
//
//        // Mostramos el resultado
//        if (esPalindromo) {
//            System.out.println("Es palíndromo");
//        } else {
//            System.out.println("No es palíndromo");
//        }

    }
}
