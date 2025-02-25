/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baraja4F;

/**
•	Main: Genera naipes aleatorios, los muestra en consola y detiene la ejecución al sacar el Rey de Oros.
•	PruebaBaraja: Crea una baraja, la muestra usando toString() y prueba el método barajar() y sacar() en el main.

 */
public class main {
    
    
    public static void main(String[] args) {
        
        Baraja baraja = new Baraja();
        
        System.out.println("******************Baraja original**********************");
        System.out.println(baraja);
        
        baraja.barajar(100);
        System.out.println("********************Baraja después de barajar******************");
        System.out.println(baraja);
        
        Naipe[] naipesSacados = baraja.sacarNaipe(10);
        System.out.println("******************Naipes sacados de la baraja: ***********************");
        for(Naipe naipe : naipesSacados){
            System.out.println(naipe);
        }
        
        System.out.println("*****************Baraja despues de sacar naipes************************** ");
        System.out.println(baraja);
    }
    
    
}
