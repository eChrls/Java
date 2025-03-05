/*
En una clase llamada Ejercicio1 , que incluye un main(), realiza un programa para gestionar un array de String
En esta clase se pide desarrollar los siguientes métodos de clase (funciones): 
A- CREAR(INT LONGITUD), devuelve un array de String de la longitud indicada en el parámetro. Este array está relleno en todas sus
posiciones con el valor de cadena vacía. Si la longitud del array es negativa entonces se puede devolver un array de tamaño cero.
B- MOSTRAR (STRING[] ARRAY), que muetra el array por consola usando el formato de contenido entre llaves y separados por guiones. 
Usa un for each. Ejemplo. crear(4) // {  -  -  - }
C- METER (STRING[] ARRAY, INT POSICION, STRING VALOR) para introducir valores String en una posicion indicada del array.
Si la posición está ocupada (no es la cadena vacía), se intenta meter en la posición siguiente, y así sucesivamente. Si se llega al
final del array, se pasa a intentarlo desde el principio hasta la posición indicada en el parámetro. Si se logra colocar el dato en
alguna posición, se devuelve TRUE. Si el array está lleno y no cabe nada más, se devuelve FALSE. 
D- BORRAR (STRING[] ARRAY, INT POSICION) para borrar el contenido de la posición indicada, moviendo el resto de los elementos que hay
a la derecha de posición para ocupar los huecos e insertando al final una cadena vacía. 
Este método devuelve true si se borra correctamente,false, en otro caso. 
 */
package Repeticiones;

import Apartados.*;
import static com.sun.tools.attach.VirtualMachine.list;
import java.lang.reflect.Array;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;

public class Ejercicio1 {

    private static String[] Crear(int longitud) {
        String vacio = "";
        String[] array = new String[longitud];
        for (int i = 0; i < array.length; i++) {
            array[i] = vacio;

        }

        return array;
    }

    private static void Mostrar(String[] array) {
        System.out.print("{");
        boolean primero  = true; 
        for (String palabra : array) {
            if (!primero){
                System.out.print(" - ");
            }
            System.out.print(palabra);
            primero = false; 

        }
        System.out.print(" }");
    }

    private static boolean Meter(String[] array, int posicion, String valor) {

        for (int i = posicion; i < array.length; i++) {
            if (array[i] != "") {

            } else {
                array[i] = valor;
                return true;
            }
        }

        for (int j = 0; j < posicion; j++) {
            if (array[j] != "") {

            } else {
                array[j] = valor;
                return true;
            }
        }

        return false;
    }

    private static boolean Borrar(String[] array, int posicion) {
        
        
        
        if(!array[posicion].isBlank()){
            
            List<String> lista = new ArrayList<>(Arrays.asList(array));
            
            lista.remove(posicion);
            lista.add("");
            lista.toArray(array);
            return true;
        }
        
            
        return false; 
    }
    
    
        
    public static void main(String[] args) {

        String[] array = new String[4];

        array = Ejercicio1.Crear(4);
        Ejercicio1.Mostrar(array);

        Ejercicio1.Meter(array, 1, "Hola");
        Ejercicio1.Mostrar(array);

        Ejercicio1.Meter(array, 2, "Adios");
        Ejercicio1.Mostrar(array);

        Ejercicio1.Meter(array, 2, "Buenos días");
        Ejercicio1.Mostrar(array);
        
        Ejercicio1.Meter(array, 2, "Buenas noches");
        Ejercicio1.Mostrar(array);
       
        Ejercicio1.Borrar(array, 1);
        Ejercicio1.Mostrar(array);
        
        Ejercicio1.Borrar(array, 0);
        Ejercicio1.Mostrar(array);

    }

}
