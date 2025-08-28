/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteA;

public class PruebaTraductor {
    public static void main(String[] args) {
        // Creamos una instancia del traductor
        Traductor traductor = new Traductor();
        
        // Añadimos 10 traducciones (inglés-español en este caso)
        traductor.guardarTraduccion("apple", "manzana");
        traductor.guardarTraduccion("book", "libro");
        traductor.guardarTraduccion("cat", "gato");
        traductor.guardarTraduccion("dog", "perro");
        traductor.guardarTraduccion("house", "casa");
        traductor.guardarTraduccion("money", "dinero");
        traductor.guardarTraduccion("pen", "bolígrafo");
        traductor.guardarTraduccion("table", "mesa");
        traductor.guardarTraduccion("water", "agua");
        traductor.guardarTraduccion("window", "ventana");
        
        // Mostramos el diccionario inicial (ordenado alfabéticamente)
        System.out.println("Diccionario inicial:");
        traductor.mostrarDiccionario();
        
        // Probamos el método de traducción
        System.out.println("\nTraducción de 'dog': " + traductor.traducir("dog"));
        
        // Modificamos una traducción
        traductor.modificarTraduccion("pen", "pluma");
        System.out.println("\nDespués de modificar 'pen':");
        traductor.mostrarDiccionario();
        
        // Borramos una traducción
        traductor.borrarTraduccion("money");
        System.out.println("\nDespués de borrar 'money':");
        traductor.mostrarDiccionario();
        
        // Obtenemos listas de palabras
        System.out.println("\nPalabras extranjeras:");
        for (String palabra : traductor.obtenerPalabrasExtranjeras()) {
            System.out.println(palabra);
        }
        
        System.out.println("\nPalabras en español:");
        for (String palabra : traductor.obtenerPalabrasEspanol()) {
            System.out.println(palabra);
        }
    }
}
