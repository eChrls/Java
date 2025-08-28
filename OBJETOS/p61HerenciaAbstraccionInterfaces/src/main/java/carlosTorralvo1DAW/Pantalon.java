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
public final class Pantalon extends Ropa {
    private String talla;

    

    public Pantalon(String talla, String pantalonPrueba, String string, double par, double par1, String pantalon_de_prueba) {
        this.talla = talla;
    }

    public Pantalon(String talla, String marca, int codigo, Double precio, int iva, String descripcion) {
        super(marca, codigo, precio, iva, descripcion);
        this.talla = talla;
    }

    public Pantalon(String talla, String marca) {
        super(marca);
        this.talla = talla;
    }

    
    
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.talla);
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
        final Pantalon other = (Pantalon) obj;
        return Objects.equals(this.talla, other.talla);
    }

    
    
    
    @Override
    public String toString() {
        return "Pantalon{" + "talla=" + talla + '}';
    }
    

}
