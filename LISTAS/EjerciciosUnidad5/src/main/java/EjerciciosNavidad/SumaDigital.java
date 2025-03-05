/*
 Suma de digitos
Dado un n.o cualquiera obtener la suma de los digitos
Ej: 623 = 6 + 2 + 3 = 11*/
package EjerciciosNavidad;

import javax.swing.JOptionPane;

public class SumaDigital {

    public static int SumaNumeros (){
        
        int resultado = 0; 
        String num = JOptionPane.showInputDialog("Introduce el número que quieras sumar por partes. Ej= 123 (1+2+3) = 6 ");
        int numero = 0; 
        resultado = 0; 
        
        try{
        for (int i = 0; i < num.length(); i++) {
            char c = (num.charAt(i));
            String posicion = Character.toString(c);
            numero = Integer.parseInt(posicion);
            resultado += numero;
        }
        }catch(NumberFormatException nfe){
            System.out.println("Entrada no numérica.");
        }

        return resultado; 
    }
}

