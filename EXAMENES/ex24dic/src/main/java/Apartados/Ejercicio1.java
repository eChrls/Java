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
package Apartados;

public class Ejercicio1 {

    public static String[] Crear(int longitud) {
        if (longitud < 0) {
            longitud = 0;
        }
        String[] StrArray = new String[longitud];

        for (int i = 0; i < StrArray.length; i++) {
           StrArray[i] = "";
        }

        return StrArray;
    }

    public static void Mostrar(String[] array) {
        System.out.print("{");
        for (String arr : array) {
            if (arr.equals("")) {
                System.out.print(" - ");
            }else{
            System.out.print(" " + arr + " ");
            }
        }
        System.out.print("}");
    }

    public static boolean Meter(String[] array, int posicion, String valor) {
        if (posicion < 0 || posicion >= array.length){
            return false;             
        }
        
      // Primero miramos desde la posición hasta el final
    for (int i = posicion; i < array.length; i++) {
        if (array[i].equals("")) {
            array[i] = valor;
            return true;
        }
    }
    
    // Si no encontramos hueco, miramos desde el principio hasta la posición
    for (int i = 0; i < posicion; i++) {
        if (array[i].equals("")) {
            array[i] = valor;
            return true;
        }
    }
    
    return false;
}
    public static boolean Borrar (String[] array, int posicion){
        if (posicion < 0 || posicion >= array.length){
            return false; 
        }
        //mover los elementos
        for (int i = posicion; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        
        array[array.length - 1] = "";
        
     return true;    
    }
    
    public static void main(String[] args) {

       // Creamos array de tamaño 4
    String[] array = Crear(4);
    
    System.out.println("Array inicial:");
    Mostrar(array);
    
    // Probamos a meter valores
    Meter(array, 0, "Uno");
    Meter(array, 0, "Dos");
    Meter(array, 1, "Tres");
    Meter(array, 1, "Cuatro");
    System.out.println("\nDespués de meter valores:");
    Mostrar(array);
    
    // Probamos a borrar
    Borrar(array, 0);
    System.out.println("\nDespués de borrar posición 0:");
    Mostrar(array);
    System.out.println("\nDespués de meter un valor en posición 1 y ver si entra al final");
    Meter(array, 1, "Comodín");
    Mostrar(array);
    
    }
}
