/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlosTorralvo1DAW;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author carlos
 */
public abstract class Libro extends Producto implements Comparable<Libro>{

    private String isbn;
    
    
    

    public Libro() {
    }

    public Libro(String isbn, int codigo, Double precio, int iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.isbn = isbn;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Libro other = (Libro) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    
    
    
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
    
    
    
    @Override
      public int compareTo(Libro o) {
        return this.isbn.compareTo(o.isbn);
    }
    
    
    
    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + '}';
    }



}
