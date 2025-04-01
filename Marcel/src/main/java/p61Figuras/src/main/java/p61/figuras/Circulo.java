/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.figuras;

import java.awt.Point;
import p61.interfaces.Movible;

/**
 *
 * @author Casa
 */
public final class Circulo extends Figura implements Movible {

    
    private int longitudRadio;
    protected Point centro = new Point(0,0);
    

    public int getLongitudRadio() {
        return longitudRadio;
    }

    public void setLongitudRadio(int longitudRadio) {
        this.longitudRadio = longitudRadio;
    }

    public Circulo() {
    }

    public Circulo(int longitudRadio, String id, String color) {
        super(id, color);
        this.longitudRadio = longitudRadio;
    }

    @Override
    public String toString() {
        return "Circulo{"+ super.toString()+",  " + "longitudRadio=" + longitudRadio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.longitudRadio;
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
        final Circulo other = (Circulo) obj;
        return this.longitudRadio == other.longitudRadio;
    }
    
    
    
    
    @Override
    public double area() {
        return Math.PI * Math.pow(this.longitudRadio, 2);
    }

    @Override
    public void moverIzq(int x) {
        centro.move(-x, 0);
    }

    @Override
    public void moverDer(int x) {
        centro.move(+x,0);
    }

    @Override
    public void moderArr(int y) {
         centro.move(+y, 0);
    }

    @Override
    public void moverAba(int y) {
        centro.move(-y, 0);
    }

    
    
    
}
