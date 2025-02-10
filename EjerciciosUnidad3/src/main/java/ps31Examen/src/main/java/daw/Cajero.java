

package daw;

import javax.swing.JOptionPane;


public class Cajero {

    public static void main(String[] args) {
      
        
        final float SALDO = 112.34f;
        
        String menu = """
                      Menu Cajero-----------
                      1. Ver saldo. 
                      2. Ingresar dinero. 
                      3. Sacar dinero.
                      ¿Que operacion quieres hacer?
                      """;
        float saldoCliente = SALDO;
        String opcion = "";
        String operacion = "";
        
        do{   
            operacion  = JOptionPane.showInputDialog(menu);
            
            switch(operacion){
                case "1" -> {
                    System.out.printf("El saldo es %.2f\n" , saldoCliente);
                    
                }
                
                case "2" -> {
                    System.out.println("Ingresar dinero. " + 
                            " Cuanto quieres ingresar?: ");
                    
                   
                    double ingreso = Funciones.pedirDouble();
                    System.out.println("El dinero a ingresar es " + ingreso); 
                    
                    saldoCliente = (float) Funciones.ingresar(ingreso, saldoCliente);
                    
                    while(ingreso<=0){
                        System.out.println("Ingresa un numero positivo." + ingreso);
                        ingreso = Funciones.pedirDouble();
                    }
                }
                
                case "3" -> {
                    System.out.println("Retirar dinero. " + 
                            " Cuanto quieres retirar?: ");
                    
                    double retirada = Funciones.pedirDouble();
                    System.out.println("El dinero a retirar es " + retirada); 
                    
                    //while que controla que sea positivo
                      while(retirada >= 0){
                        System.out.println("Ingresa un numero positivo." + retirada);
                        
                        saldoCliente = (float) Funciones.retirar(retirada, saldoCliente);
                        
                        String resultado="""
                                         El saldo restante es: %.3f
                                         """.formatted(saldoCliente);
                        
                        
                        if(saldoCliente >= retirada){
                            //hago la operacion
                        }
                        else{
                            System.out.println("No tienes suficiente dinero");
                        }
                    }
                    
                }
                default ->{
                            System.out.println("No has seleccionado una opción correcta.");
                }
                
            }
            
            opcion = JOptionPane.showInputDialog("Quieres realizar otra operacion o salir (otra/salir)");
            
            opcion = (opcion == null)? "salir":opcion;//en caso de pulsar cancelar da excepcion, pq se guardaria un null
            //como la variable opcion seria null, interpretamos que quiere salir, sino es null le damos el valor que haya elegido. 
            
            while(!opcion.equals("salir") && !opcion.equals("otra")){
                
                opcion = JOptionPane.showInputDialog("Opcion incorrecta..." + "Introduce otra o salir");
            }
        } while(opcion.equals("otra"));
        
    }
}
