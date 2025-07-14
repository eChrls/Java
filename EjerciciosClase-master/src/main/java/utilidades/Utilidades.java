package utilidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Utilidades {
    
    // Common error messages
    private static final String ERROR_VALOR_INCORRECTO = ERROR_VALOR_INCORRECTO;
    private static final String ERROR_RANGO = ERROR_RANGO + ;
    private static final String MSG_NUMERO_ENTERO = "Introduce un numero entero";
    private static final String MSG_NUMERO_DECIMAL = "Introduce un número decimal";
    
    // Static Random instance for better performance
    private static final Random RANDOM = new Random();

    public static int filtrarNumeroEnteroScanner(String msj) {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;
        boolean seguir = true;
        do {

            System.out.println(msj);

            try {
                numero = entrada.nextInt();
                seguir = false;
            } catch (InputMismatchException ime) {
                System.out.println(ERROR_VALOR_INCORRECTO);
            }

            entrada.nextLine();
        } while (seguir);

        return numero;
    }

    public static int filtrarNumeroEnteroScannerRango(int minimo, int maximo,String msj) {

        Scanner entrada = new Scanner(System.in);

        int numero = 0;
        boolean seguir = true;
        do {

            System.out.println(msj);

            try {
                numero = entrada.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    seguir = false;
                } else {
                    System.out.println(ERROR_RANGO + minimo + " y " + maximo);
                }
            } catch (InputMismatchException ime) {
                System.out.println(ERROR_VALOR_INCORRECTO);
            }

            entrada.nextLine();
        } while (seguir);

        return numero;
    }

    public static int filtrarNumeroEnteroJOptionPane(String msj) {

        int numero = 0;
        boolean seguir = true;
        do {

            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(msj));
                seguir = false;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, ERROR_VALOR_INCORRECTO);
            }

        } while (seguir);

        return numero;
    }

    public static int filtrarNumeroEnteroJOptionPaneRango(int minimo, int maximo,String msj) {

        int numero = 0;
        boolean seguir = true;
        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(msj));
                if (numero >= minimo && numero <= maximo) {
                    seguir = false;
                } else {
                    JOptionPane.showMessageDialog(null, ERROR_RANGO +  + minimo + " y " + maximo);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, ERROR_VALOR_INCORRECTO);
            }
        } while (seguir);
        return numero;
    }
    
    
    
    
    public static double filtrarNumeroDecimalScanner(String msj) {

        Scanner entrada = new Scanner(System.in);

        double numero = 0;
        boolean seguir = true;
        do {

            System.out.println(msj);

            try {
                numero = entrada.nextDouble();
                seguir = false;
            } catch (InputMismatchException ime) {
                System.out.println(ERROR_VALOR_INCORRECTO);
            }

            entrada.nextLine();
        } while (seguir);

        return numero;

    }

    public static double filtrarNumeroDecimalScannerRango(double minimo, double maximo,String msj) {

        Scanner entrada = new Scanner(System.in);

        double numero = 0;
        boolean seguir = true;
        do {

            System.out.println(msj);

            try {
                numero = entrada.nextDouble();
                if (numero >= minimo && numero <= maximo) {
                    seguir = false;
                } else {
                    System.out.println(ERROR_RANGO +  + minimo + " y " + maximo);
                }
            } catch (InputMismatchException ime) {
                System.out.println(ERROR_VALOR_INCORRECTO);
            }

            entrada.nextLine();
        } while (seguir);

        return numero;
    }

    public static double filtrarNumeroDecimalJOptionPane(String msj) {

        double numero = 0;
        boolean seguir = true;
        do {

            try {
                numero = Double.parseDouble(JOptionPane.showInputDialog(msj));
                seguir = false;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, ERROR_VALOR_INCORRECTO);
            }

        } while (seguir);

        return numero;
    }

    public static double filtrarNumeroDecimalJOptionPaneRango(double minimo, double maximo,String msj) {

        double numero = 0;
        boolean seguir = true;
        do {
            try {
                numero = Double.parseDouble(JOptionPane.showInputDialog(msj));
                if (numero >= minimo && numero <= maximo) {
                    seguir = false;
                } else {
                    JOptionPane.showMessageDialog(null, ERROR_RANGO +  + minimo + " y " + maximo);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, ERROR_VALOR_INCORRECTO);
            }
        } while (seguir);
        return numero;
    }
    
    
    
    public static int numeroEnteroRandom(int minimo, int maximo) {
        return RANDOM.nextInt(maximo - minimo + 1) + minimo;
    }

    public static double numeroDecimalRandom(double minimo, double maximo) {
        return RANDOM.nextDouble(maximo - minimo + 1) + minimo;
    }

    public static String pedirString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
    
    public static void rellenarMatrizEnteros(int[][] mat, int min,int max){
    
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = numeroEnteroRandom(min, max);
            }
        }
    }
    
    public static void imprimirMatrizEnteros(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j < mat[i].length - 1) {
                    System.out.print("[" + mat[i][j] + "]" + "-");
                } else {
                    System.out.print("[" + mat[i][j] + "]");
                }
            }
            System.out.println("");
        }
    }
    
    public static void imprimirMatrizChar(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j < mat[i].length - 1) {
                    System.out.print("[" + mat[i][j] + "]" + "-");
                } else {
                    System.out.print("[" + mat[i][j] + "]");
                }
            }
            System.out.println("");
        }
    }
    
      /**
     * Genera los primeros n números de la serie de Fibonacci.
     * @param n cantidad de términos a generar
     * @return lista con los primeros n términos de Fibonacci
     */
    public static List<Integer> generarFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        if (n <= 0) return fibonacci;
        fibonacci.add(0);
        if (n == 1) return fibonacci;
        fibonacci.add(1);
        for (int i = 2; i < n; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
        }
        return fibonacci;
    }
}
