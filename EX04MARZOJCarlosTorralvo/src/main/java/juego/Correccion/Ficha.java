/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Random;

/**
 *
 * @author carlos
 */

public class Ficha {

    private int numero;
    private Color color;
    public final int NUMEROMAYOR = 13;
    public final int NUMEROMENOR = 1;

    //Constructor vacío que genera una ficha aleatoria
//Utiliza Color.values() para obtener el array de todos los tipos de palos disponibles
//Selecciona un color aleatorio usando r.nextInt(Color.values().length) que genera un índice entre 0 y el número total de palos-1
//Ejemplo: Si hay 4 colores, genera un número entre 0 y 3,
//Luego asigna un número aleatorio entre 1 y 11 (inclusivo-exclusivo, por lo que será entre 1 y 10)
    public Ficha() {
        Random r = new Random();
        this.color = Color.values()[r.nextInt(Color.values().length)];
        this.numero = r.nextInt(1, 14);

    }

    
    //Constructror parametrizado
    public Ficha(int numero, Color color, int NUMEROMAYOR, int NUMEROMENOR) {
        this.numero = numero;
        this.color = color;
    }


    public int getNumero() {
        if(numero>0 && numero <14 ){
            return numero;
        }else{
              throw new IllegalArgumentException ("Numero no valido");
        }
    }
    

    public void setNumero(int numero) {
        if(numero>0 && numero <14 ){
        this.numero = numero;
        }else{
            throw new IllegalArgumentException ("Numero no valido");
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ficha other = (Ficha) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return this.color == other.color;
    }

    @Override
    public String toString() {
        return "Ficha{" + "numero=" + numero + ", color=" + color + '}';
    }

    
    
    
    
    
}
