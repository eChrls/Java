
package daw;

import javax.swing.JOptionPane;


public class Funciones {
    
    public static double ingresar (double ingreso, double saldoCliente){
        
        return ingreso + saldoCliente;
    }
    
    public static double retirar (double ingreso, double saldoCliente){
        
        return saldoCliente - ingreso;
    }
    
    public static double pedirDouble (){
        double dato = 0.0;
        
        do{
            String numeroTexto= JOptionPane.showInputDialog("Introduce el numero"); 
            
            try{
                dato = Double.parseDouble(numeroTexto);
                return dato;
            }catch (NumberFormatException nfe){
                System.out.println("Valor introducido incorrecto.");    
            }
            
        }while(true);
    }
}

    

 
