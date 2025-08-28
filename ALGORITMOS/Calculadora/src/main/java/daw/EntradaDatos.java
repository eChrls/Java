package daw;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EntradaDatos {
    //Metodo de clase (=static) para leer un numero int
    //Si el usuario se equivoca y no pone un int el metodo debe
    //poner un int otra vez
    public static int leerScanner(){
        Scanner sc = new Scanner (System.in);
        int opcion = 0;
        
        do { 
        //Posible excepcion InputMisMatch en nextInt si entran caracteres               
        //Ponemos el código susceptible de error en un try catch
            try{                
                System.out.println("Introduce un numero entero");
                opcion = sc.nextInt();
                //En el catch() ponemos la excepción a gestionar.
                //nombramos el objeto como sea, nosotros le llamamos = IME de InputMismachtExceptionó
                //Si llega la ejecucion a esta linea significa que no hay excepcion
                //es un int
                return opcion; 
            }catch(InputMismatchException ime){ 
                //Aqui dentro pongo el codigo para recupearme del error
                System.out.println("No has introducido un numero o es demasiado grande");
                sc.nextLine();//IMPORTANTE Para limpiar el catch, sino se repite en bucle
                //Opcion es 0 en este punto si te equivocas 
                opcion = 0;
            }   
        }while (true);
       }
        
        
    public static int leerDialogo(){
        int dato = 0;
        String texto = " ";        
 
        do{
        texto = JOptionPane.showInputDialog("Introduce un entero: ");
        
        try{
            dato = Integer.parseInt(texto);
            return dato;
        }catch(NumberFormatException nfe){
               System.out.println("Te has equivocado de numero");
            }    
        }while (true);
        //SI USAMOS PROPIEDADES O METODOS DE UN OBJETO NULL
        // ENTONCES EXCEPCION NULLPOINTER. Ej. texto.length o el joption     
    }    
}

