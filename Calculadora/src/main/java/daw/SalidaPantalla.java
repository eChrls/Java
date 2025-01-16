
package daw;


public class SalidaPantalla {
    //Metodos estaticos (funciones) relacionadas con la salida 
    //por pantalla
      
public static void mostrarMenu(){
              System.out.println("SUPERCALCULADORA");  
        
            String menu = """
                      Introduce una opcion (1-5):
                      1. - Sumar
                      2. - Restar
                      3. - Multiplicar
                      4. - Dividir
                      5. - Salir
                """;        
            System.out.println(menu);
    }  
}
