
package Examen1;
import java.util.*;
import javax.swing.*;

public class PrimerExamen {
    
        
    
            //PEDIR CON SCANNER ALGO Y QUE INTRODUZCAN OTRA COSA
            //TRY CATCH INPUT MISMATCH EXCEPTION
    public static int leerScannerv1(){
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
                //break si se cumple para evitar bucle infinito
                //tambien es posible return opcion, a continuacion hacemos metodo v2 mostrandolo.
                break; 
                }catch(InputMismatchException ime){ 
                //Aqui dentro pongo el codigo para recupearme del error
                System.out.println("No has introducido un numero o es demasiado grande");
                sc.nextLine();//IMPORTANTE Para limpiar el catch, sino se repite en bucle
                //Opcion es 0 en este punto si te equivocas 
                opcion = 0;
                }   
            }while (true);
    
            return opcion;
    }        
            //CONVERTIR TEXTO STRING EN NUMERO
            //TRY CATCH NUMBER FORMAT EXCEPCION. 
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
    

          //STRING FORMATTED
          int contagios, tasa;
          String resultado = """
                       Resultados de Tasa de Contagios:
                       Número de habitantes: 75000
                       Número de contagios: %d
                       Tasa de contagios por cada 100mil habitantes: %.3f
                       """.formatted(contagios, tasa);

                    JOptionPane.showMessageDialog (null, resultado);
        
                    
        //PASAR UN STRING A INT Y REDONDEAR HACIA ARRIBA            
        int horasMaster;
        int horasProfesor;
        //Pedimos los datos del número de másters con JOptionPane y transformamos a INT
        String numMasterStr = JOptionPane.showInputDialog("Introduce el número de másters para calcular información: ");
        int numMaster = Integer.parseInt(numMasterStr);
        //Repetimos los cálculos
        int profNecesarios = (int) Math.ceil((double) (numMaster * horasMaster) / horasProfesor);  
        
        
        //BUCLE DOBLE BASICO PARA RECORRER i
        int solucion = 0;   
        //bucle for doble para recorrer del 1 al 10 dentro de i. 
        for (int i = 1; i < 11; i++) {

            for (int j = 1; j < 11; j++) {
                solucion = i * j;
                System.out.println(solucion);

            }

        }
        //PIRÁMIDE 

         Scanner s = new Scanner (System.in);       
        int altura = s.nextInt();
        
        if (altura < 1 || altura > 10){
            System.out.println("Altura introducida incorrecta, vuelva a empezar e introduzca un nº del 1 al 10");
            
            }else{
                for (int i = 1; i <= altura; i++) {
                    for( int j = 1; j <= i; j++){
                        System.out.print(i);                               
                    }//aqui el bucle for doble consiste en que la j tendrá el mismo recorrido que el valor de i
                    //y i tendrá el mismo recorrido que la altura. Cada vez que j recorre una i imprime pantalla. Hasta que acabe el total de i.
                    System.out.println();
            }
        }     
            while (mes <= 0 || mes >=13);
    //SWITCH clasificando a los meses en grupos por dias.
        switch (mes) {
            case 4, 6, 9, 11:
            System.out.println("El mes tiene 30 días");
            break;
            case 1, 3, 7, 8, 10, 12:
            System.out.println("El mes tiene 31 días");
            break;
            default:
            System.out.println("El mes tiene 28 días");
    }
                
        //BUCLE DO WHILE CON RESPUESTA STRING        
                do{
    
                    System.out.print("¿Hay otro cliente en caja? (si/no): ");
                    respuesta = scanner.nextLine().toLowerCase();

                } while (respuesta.equals("si"));
                
                //TRIPLE BUCLE FOR
                
                 for(int i = 0; i <ciudades; i++){
            importeCiudades = 0;
            System.out.println("Ciudad numero   " + (i + 1) + "\n");
                for(int j = 0; j < tiendas ; j++){
                    importeTiendas = 0;
                    System.out.println("Tienda numero " + (j + 1) + "\n");
                        for (int k = 0; k < trabajadores; k++){
                            importeEmpleados = 0;
                            System.out.println("Introduce las ventas del empleado: ");
                            importeEmpleados = s.nextInt();
                            importeTotalEmpleados += importeEmpleados;

    public static void main(String[] args) {   


    }
         
           
}         
    
    

