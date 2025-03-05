/* Ejercicio: Generar una lista de 50 pines de 4 dígitos aleatorios únicos,
   y verificar si un pin ingresado por el usuario está en esta lista. */

package EstructurasDeAlmacenamiento.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EjArrayList4Corregido {

    public static void main(String[] args) {
        // ERROR: En el código original, el bucle generaba 51 pines en lugar de 50.
        // Además, añadía el mismo array `pin` repetidamente debido a que se utilizaba la misma referencia.
        // También permitía que los pines tuvieran dígitos repetidos.
        //
        // Solución: Se utiliza el método `generarListaPines` que asegura crear 50 pines distintos con
        // dígitos únicos y los almacena en una lista sin repetir referencias.
        
        /*
        Random random = new Random();
        ArrayList<int[]> listaPin = new ArrayList<>(50);
        int[] pin = new int[4];
        for (int i = 0; i < 51; i++) { // ERROR: Debe ser `i < 50` para crear exactamente 50 pines.
            for (int j = 0; j < pin.length; j++) {
                pin[j] = random.nextInt(10);  // Genera un dígito aleatorio, pero los pines pueden no ser únicos.
            }
            listaPin.add(pin);  // ERROR: Se añade la misma referencia `pin`, no un nuevo array.
        }
        */

        // CORRECCIÓN: Genera y almacena 50 pines de 4 dígitos únicos en la lista `listaPin`.
        ArrayList<int[]> listaPin = generarListaPines(50);

        // Pide al usuario un número para verificar si hay pines que contengan ese dígito
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número del 0 al 9 para buscar en los pines:");
        int digito = sc.nextInt();

        // CORRECCIÓN: Filtra los pines que contienen el dígito especificado y muestra el resultado.
        ArrayList<int[]> pinesFiltrados = listaFiltrada(listaPin, digito);

        if (pinesFiltrados.isEmpty()) {
            System.out.println("No hay pines que contengan el número " + digito);
        } else {
            System.out.println("Pines que contienen el número " + digito + ":");
            mostrarPines(pinesFiltrados); // Muestra los pines filtrados
        }

        // Solicita un pin específico de 4 dígitos al usuario y verifica si está en la lista
        int[] pinUsuario = solicitarPinUsuario(sc);
        
        if (existePin(listaPin, pinUsuario)) {
            System.out.println("El pin ingresado está en la lista.");
        } else {
            System.out.println("El pin ingresado no está en la lista.");
        }
    }

    // Genera una lista de `cantidad` pines de 4 dígitos únicos cada uno
    public static ArrayList<int[]> generarListaPines(int cantidad) {
        Random random = new Random();
        ArrayList<int[]> listaPin = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            int[] pin;
            do {
                pin = generarPinAleatorio(random); // Genera un pin aleatorio
            } while (contienePin(listaPin, pin)); // Asegura que el pin sea único

            listaPin.add(pin); // Añade el pin a la lista
        }
        return listaPin;
    }

    // Genera un pin de 4 dígitos únicos
    private static int[] generarPinAleatorio(Random random) {
        int[] pin = new int[4];
        for (int i = 0; i < pin.length; i++) {
            int digito;
            do {
                digito = random.nextInt(10);
            } while (contieneDigito(pin, digito, i)); // Asegura que el dígito no se repita en el pin
                                                      // Si el dígito ya está en `pin`, vuelve a intentar
            /*Si contieneDigito devuelve true: Significa que el dígito ya está en pin hasta la posición i-1, 
            por lo que el do-while repetirá el ciclo para generar otro dígito.*/
            pin[i] = digito;
        // Si no se repite, asigna el dígito al arreglo `pin` en la posición `i`            
        }
        return pin;
    }

    // Recorre el array `pin` y verifica i por i si ya contiene el dígito hasta la posición `hasta`
    //La posición hasta será i, por lo que optimizará el array para no recorrerlo entero, solo hasta donde llegue i. 
    private static boolean contieneDigito(int[] pin, int digito, int hasta) {
        for (int i = 0; i < hasta; i++) {
            if (pin[i] == digito) {
                return true; // Retorna true si el dígito ya está en `pin` hasta la posición `hasta`
            }
        }
        return false; // Retorna false si el dígito no se encuentra en `pin` hasta la posición `hasta`
    }

    // Método para filtrar pines que contienen un dígito específico
    public static ArrayList<int[]> listaFiltrada(ArrayList<int[]> lista, int digito) {
        ArrayList<int[]> listaPinesFiltrada = new ArrayList<>();

        /*
        ERROR: En el código original, se intentaba acceder a `pin[i]` en lugar de `lista.get(i)[j]`.
        Además, `listaPinesFiltrada` se inicializaba como `null`, lo que causaría un error al intentar añadir elementos.
        
        Solución: Usar `for-each` para recorrer cada pin y `for` interno para verificar cada dígito dentro de cada pin.
        */
        /*
        ArrayList<int[]> listaPinesFiltrada = null;  // ERROR: La lista no debe ser nula.

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < pin.length; j++) {
                // ERROR: `pin[i]` es incorrecto porque `pin` no es la lista de pines.
                if (num == pin[i]) {
                    listaPinesFiltrada.add(pin);                                        
                }         
            }
        }
        */

        // CORRECCIÓN: Recorrer cada pin de la lista y verificar si contiene el dígito solicitado.
        for (int[] pin : lista) {
            for (int num : pin) {
                if (num == digito) {  // Comprueba si el dígito está en el pin
                    listaPinesFiltrada.add(pin);  // Añade el pin a la lista filtrada
                    break; // Evita añadir el mismo pin múltiples veces si tiene el dígito repetido
                }
            }
        }
        return listaPinesFiltrada;
    }

    // Método para verificar si un pin específico ya está en la lista
    private static boolean contienePin(ArrayList<int[]> lista, int[] pin) {
        for (int[] p : lista) {
            if (Arrays.equals(p, pin)) {
                return true;
            }
        }
        return false;
    }

    // Solicita un pin de 4 dígitos al usuario y lo almacena en un array
    private static int[] solicitarPinUsuario(Scanner sc) {
        int[] pinUsuario = new int[4];
        System.out.println("Introduce un pin de 4 dígitos para verificar si está en la lista:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Introduce el dígito " + (i + 1) + ": ");
            pinUsuario[i] = sc.nextInt();
        }
        return pinUsuario;
    }

    // Método para verificar si un pin específico está en la lista de pines generados
    public static boolean existePin(ArrayList<int[]> lista, int[] pinBuscado) {
        for (int[] pin : lista) {
            if (Arrays.equals(pin, pinBuscado)) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar los pines de una lista
    public static void mostrarPines(ArrayList<int[]> listaPines) {
        for (int[] pin : listaPines) {
            for (int digito : pin) {
                System.out.print(digito);
            }
            System.out.println();
        }
    }
}
