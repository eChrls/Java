/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baraja4F;

import java.util.Random;

/**
 *
 * @author Casa
 */
public class Naipe {
    //•Atributos: Un objeto de tipo Palo y el número de la carta (1, 2, 3, 4, 5, 6, 7, Sota, Caballo, Rey).
    private Palos palo; 
    private int numero; 
    
    //Constructor parametrizado: Acepta un Palo y un número de carta.
    public Naipe(Palos palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }
//Constructor vacío que genera un naipe aleatorio
//Utiliza Palos.values() para obtener el array de todos los tipos de palos disponibles
//Selecciona un palo aleatorio usando r.nextInt(Palos.values().length) que genera un índice entre 0 y el número total de palos-1
//Ejemplo: Si hay 4 palos, genera un número entre 0 y 3, y luego selecciona ese palo del array con Palos.values()[índice]
//Luego asigna un número aleatorio entre 1 y 11 (inclusivo-exclusivo, por lo que será entre 1 y 10)
    public Naipe() {
        Random r = new Random();
        this.palo = Palos.values()[r.nextInt(Palos.values().length)];
        this.numero = r.nextInt(1, 11);
    }

    public Palos getPalo() {
        return palo;
    }

    public void setPalo(Palos palo) {
        this.palo = palo;
    }

    public int getNumero() {
        if(numero>0 && numero <11 ){
        }
         return numero;
    }

    public void setNumero(int numero) {
          if(numero>0 && numero <11 ){
        this.numero = numero;
        }
    }
//•toString(): Debe retornar "Sota", "Caballo" o "Rey" si el número de la carta es 8, 9 o 10, respectivamente.
    @Override
    public String toString() {
        String cartaString;
        cartaString = switch (numero){
            case 8 -> cartaString = "SOTA";
            case 9 -> cartaString = "CABALLO";
            case 10 -> cartaString = "REY";
            default -> cartaString = String.valueOf(numero);
        };
            
        return cartaString + "  de  " + palo ;
    }
    
    
    
    
    
    
    
    
}
