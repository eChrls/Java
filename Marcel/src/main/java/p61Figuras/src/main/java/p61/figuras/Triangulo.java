/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.figuras;


/**
 *
 * @author Casa
 */
public final class Triangulo extends Poligono implements Comparable<Triangulo>{

    public Triangulo() {
        
    }

    public Triangulo(int base, int altura, int par2, String id, String color) {
        super( id, color, base, altura,  3);
    }
    
    



    @Override
    public double area() {
        return (this.getBase() * this.getAltura())/2;
    }

    @Override
    public String toString() {
        return "Triangulo { " + super.toString();
    }



    @Override
    public int compareTo(Triangulo o) {
        return Integer.compare(this.getBase(), o.getBase());
    }


    
}
