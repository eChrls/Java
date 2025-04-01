/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.figuras;

import java.awt.Point;

/**
 *
 * @author Casa
 */
public abstract class Poligono extends Figura {
    
    private int base;
    private int altura;
    private int numeroLados;
    protected Point puntoInicial = new Point(0,0);
    
    
    public Poligono(String id, String color, int base, int altura, int numeroLados) {
        super(id, color);
        this.base = base;
        this.altura = altura;
        this.numeroLados = numeroLados;
    }
    
    
 
    
       public Poligono() {
    }
    

    
    
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumeroLados() {
        return numeroLados;
    }

    public void setNumeroLados(int numeroLados) {
        this.numeroLados = numeroLados;
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
        final Poligono other = (Poligono) obj;
        if (this.base != other.base) {
            return false;
        }
        if (this.altura != other.altura) {
            return false;
        }
        return this.numeroLados == other.numeroLados;
    }

    @Override
    public String toString() {
        return "Poligono{" + "base=" + base + ", altura=" + altura + ", numeroLados=" + numeroLados + '}';
    }

 


    
    
}
