/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlosTorralvo1DAW;

import java.util.Objects;

/**
 *
 * @author carlos
 */
public abstract class Ropa extends Producto implements SeEnvia{
    private String marca; 

    
    
    
    public Ropa() {
    }

    public Ropa(String marca, int codigo, Double precio, int iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.marca = marca;
    }

    public Ropa(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Ropa{" + "marca=" + marca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.marca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
         if (!super.equals(obj)) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ropa other = (Ropa) obj;
        return Objects.equals(this.marca, other.marca);
    }
    
    
    
    public void enviar(String direccion){
        System.out.println("Ropa con id= " + this.getCodigo() + " se envía a " + direccion);
        
    }
    
    
    
}
