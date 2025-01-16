/*
5.- Usando JOptionPane, solicita al usuario que introduzca una frase cualquiera, 
guardando la frase en un objeto String.
Muestra la frase por consola y su tamaño.
Indica el índice de la primera ocurrencia de la letra ‘a’. Usa el método indexOf.
Crea un método para devolver una lista con las posiciones donde se encuentre 
el char que se pasa como parámetro.
Crea un método que recorra todas las letras de tu frase, imprimiendo su valor unicode e indicando
si es una letra mayúscula o minúscula o un dígito. Usa la clase envolvente Character.
Elimina todos los espacios en blanco que haya en la cadena. 
Imprime la nueva cadena y su tamaño.
*/
package EstructurasDeAlmacenamiento.ArrayList;
import java.util.*;
import javax.swing.*;
public class EjArrayList5 {
   
    public static void main(String[] args) {
       String frase = JOptionPane.showInputDialog("Introduce una palabra o frase para analizarla: ");
    
        EjArrayList5.analisisFrase(frase);
        
        System.out.println("Analsis de los caracteres: ");
        EjArrayList5.analisisProfundo(frase);
        
    }
    
    public static void analisisFrase(String objeto){
        int tamaño = objeto.length();
        int posicionA = objeto.indexOf('a');
        
        String analisis = """
                        "El tamaño (contando espacios) de :..."%s" 
                        Es igual a ............................%d
                        Su primera letra "a" está 
                        en la posición.........................%d
                                                  
                          """.formatted(objeto, tamaño, posicionA);
        
        System.out.println(analisis);

    }
    
    public static void analisisProfundo (String objeto){
        
        //removemos espacios en blanco
        String sinespacios = objeto.strip();
        System.out.println("Nuevo tamaño sin espacios en blanco = " + sinespacios.length());
        
        for (int i = 0; i < objeto.length(); i++) {
            char caracter = objeto.charAt(i);
            int valorUnicode = (int) caracter;
             if (Character.isUpperCase(caracter)) {
                System.out.printf("Carácter: '%c' | Unicode: %d | Tipo: Letra mayúscula%n", caracter, valorUnicode);
            } else if (Character.isLowerCase(caracter)) {
                System.out.printf("Carácter: '%c' | Unicode: %d | Tipo: Letra minúscula%n", caracter, valorUnicode);
            } else if (Character.isDigit(caracter)) {
                System.out.printf("Carácter: '%c' | Unicode: %d | Tipo: Dígito%n", caracter, valorUnicode);
            } else {
                System.out.printf("Carácter: '%c' | Unicode: %d | Tipo: Otro símbolo%n", caracter, valorUnicode);
            }
        }
    }
        
        
        
        
    
    
    
}
