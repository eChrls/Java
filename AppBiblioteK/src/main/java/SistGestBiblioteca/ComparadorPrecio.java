/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistGestBiblioteca;

import java.util.Comparator;

/**
 *
 * @author Casa
 */
public class ComparadorPrecio implements Comparator<Libro>{
        
        //Comparamos los precios de los libros y utilizamos Double.compare para evitar problemas con decimales.
        @Override
        public int compare(Libro libro1, Libro libro2) {
            return Double.compare(libro1.getPrecio(), libro2.getPrecio());
            //  return id - otro.id; 
        }
}

