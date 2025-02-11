
package main;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class funciones {
    

    public static double introducirNumero (double num){
    Scanner sc = new Scanner(System.in);
    String texto = "";
    
        do { 
        //Posible excepcion InputMisMatch en nextInt si entran caracteres               
        //Ponemos el código susceptible de error en un try catch
            texto = JOptionPane.showInputDialog("Introduce un numero: ");
            try{                
                num = Double.parseDouble(texto);
            
                    return num;
                    
                }catch(NumberFormatException nfe){
                    
                    System.out.println("Te has equivocado de numero");
                    }    
            
            }while (true);    
        
    }
    
    public static double ingresar (double saldoIni, double saldoFin){
         Scanner sc = new Scanner (System.in);
             
         
         
        System.out.println("Por favor introduzca la cantidad a ingresar: ");
        double cantidad = sc.nextDouble();
        if (cantidad < 0 ){
            System.out.println("Cantidad introducida incorrecta, vuelva a intentarlo");       
        }else {
        
            saldoFin = saldoIni + cantidad;
            
            saldoIni = saldoFin;
  
        }
   
        //formatted para joptionpane con 3 decimales
        String saldo = """
                       Ingreso realizado. 
                       
                       Su saldo actual es: %.3f%n
                       
                       """.formatted();

                    JOptionPane.showMessageDialog (null, saldo);
     
                    return saldoFin;           

    }
    
     public static double sacar (double saldoIni, double saldoFin){
   
         
           /* saldoFin = saldoIni - funciones.introducirNumero(num);*/
        

                    return saldoFin;
    }



}   
        
        
        
        
        
        
    
    
    
    
    
    
    

