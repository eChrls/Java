/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.figuras;

import p61.interfaces.Dibujable;
import p61.interfaces.Movible;

/**
 *
 * @author Casa
 */
public final class Rectangulo extends Poligono implements Movible, Dibujable {

    
    
    public Rectangulo(int base, int altura, int numeroLados, String id, String color) {
        super(id, color, base, altura, numeroLados);
    }

    public Rectangulo() {
    }
    
    
    

    @Override
    public void moverIzq(int x) {
        puntoInicial.move(-x, 0);
    }

    @Override
    public void moverDer(int x) {
        puntoInicial.move(+x,0);
    }

    @Override
    public void moderArr(int y) {
         puntoInicial.move(+y, 0);
    }

    @Override
    public void moverAba(int y) {
        puntoInicial.move(-y, 0);
    }

    @Override
    public void dibujar() {
        for (int i = 0; i < this.getBase(); i++) {
         System.out.print("*");
        }System.out.println("");
         for (int i = 0; i < this.getAltura()-2; i++) {
         System.out.print("*");
             for (int j = 0; j < this.getBase()-2; j++) {
                 System.out.print(" ");
             }
             System.out.println("*");
        }
        for (int i = 0; i < this.getBase(); i++) {
         System.out.print("*");
        }
        System.out.println("");
       
       
    }

    @Override
    public double area() {
        return this.getBase() * this.getAltura();
    }

    @Override
    public String toString() {
        return "Rectangulo { " + super.toString();
    }
    
    
    
    
    
    
    
    
    
    
}
