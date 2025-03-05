/* 4.- Implementa un programa que genere una lista de 50 números pin aleatorios
diferentes. En un método de clase, que recibe una lista de pines 
y un digito(0-9) se debe devolver en otra lista aquellos pines que 
contienen ese número. Si no hay ninguno devuelve una lista vacía. 
En el programa principal, pide un pin al usuario y usando la función 
anterior se debe saber si ese pin está en la lista inicial o no. 
Los dígitos del pin no se repiten y se guardan en un array de int.
*/

package EstructurasDeAlmacenamiento.ArrayList;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class EjArrayList4B {

    public static void main(String[] args) {
        // Genera una lista de 50 pines de 4 dígitos cada uno, sin repetición de dígitos
        ArrayList<int[]> listaPin = generarListaPines(50);

        // Solicita un dígito (0-9) para buscar en los pines
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un dígito del 0 al 9: ");
        int digito = sc.nextInt();

        // Filtra y obtiene los pines que contienen el dígito ingresado
        ArrayList<int[]> pinesFiltrados = listaFiltrada(listaPin, digito);

        // Muestra el resultado de la búsqueda
        if (pinesFiltrados.isEmpty()) {
            System.out.println("No hay pines con el dígito " + digito);
        } else {
            System.out.println("Pines con el dígito " + digito + ":");
            mostrarPines(pinesFiltrados);
        }

        // Solicita un pin específico de 4 dígitos para buscar en la lista
        System.out.println("Introduce un pin de 4 dígitos para verificar:");
        int[] pinUsuario = new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Dígito " + (i + 1) + ": ");
            pinUsuario[i] = sc.nextInt();
        }

        // Verifica si el pin ingresado por el usuario está en la lista
        if (existePin(listaPin, pinUsuario)) {
            System.out.println("El pin está en la lista.");
        } else {
            System.out.println("El pin no está en la lista.");
        }
    }

    // Genera una lista de `cantidad` pines de 4 dígitos con dígitos únicos en cada pin
    public static ArrayList<int[]> generarListaPines(int cantidad) {
        Random random = new Random();
        ArrayList<int[]> listaPin = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            int[] pin = new int[4];
            for (int j = 0; j < pin.length; j++) {
                int nuevoDigito;
                do {
                    nuevoDigito = random.nextInt(10); // Genera un dígito aleatorio (0-9)
                } while (contiene(pin, nuevoDigito, j)); // Evita repetir dígitos en el mismo pin
                pin[j] = nuevoDigito;
            }
            listaPin.add(pin); // Añade el pin creado a la lista
        }
        return listaPin;
    }

    // Verifica si un arreglo contiene un dígito hasta un índice específico
    private static boolean contiene(int[] pin, int digito, int hasta) {
        for (int i = 0; i < hasta; i++) {
            if (pin[i] == digito) {
                return true; // Devuelve `true` si el dígito ya está en el pin
            }
        }
        return false;
    }

    // Filtra pines que contienen un dígito específico
    public static ArrayList<int[]> listaFiltrada(ArrayList<int[]> lista, int digito) {
        ArrayList<int[]> listaPinesFiltrada = new ArrayList<>();
        for (int[] pin : lista) {
            for (int num : pin) {
                if (num == digito) { // Si encuentra el dígito, agrega el pin a la lista filtrada
                    listaPinesFiltrada.add(pin);
                    break; // Rompe el bucle interno una vez que encuentra el dígito
                }
            }
        }
        return listaPinesFiltrada;
    }

    // Comprueba si un pin específico está en la lista de pines
    public static boolean existePin(ArrayList<int[]> lista, int[] pinBuscado) {
        for (int[] pin : lista) {
            if (Arrays.equals(pin, pinBuscado)) { // Compara dos pines para ver si son iguales
                return true; // Devuelve `true` si encuentra el pin
            }
        }
        return false; // Devuelve `false` si no encuentra el pin
    }

    // Muestra los pines en la lista en la salida
    public static void mostrarPines(ArrayList<int[]> listaPines) {
        for (int[] pin : listaPines) {
            for (int digito : pin) {
                System.out.print(digito); // Imprime cada dígito del pin
            }
            System.out.println(); // Salto de línea después de cada pin
        }
    }
}
