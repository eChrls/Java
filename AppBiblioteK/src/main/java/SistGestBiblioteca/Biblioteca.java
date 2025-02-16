/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistGestBiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    
    private List<Libro> libros; 
    
    //Constructor
    public Biblioteca() {
        //Inicializamos
        this.libros= new ArrayList<>();
    }
    
        
    public void AgregarLibros(Libro libro){
        
        libros.add(libro);
        
    }
    
    public void MostrarLibros(){
        System.out.println("Lista de libros: ");
        libros.forEach(libro -> System.out.println(libro));
    }
    //Metodo para ordenar por precio usando el comparador que creamos 
    public void ordenarPorPrecio(){
      Collections.sort(libros, new ComparadorPrecio());
    }
    //Metodo para buscar un libro por ID
    //Primero ordenamos por ID y luego usamos busqueda binaria
    public Libro buscarPorId(int id){
        Collections.sort(libros);
        
        int indice = Collections.binarySearch(libros, 
                new Libro(id, "", "", LocalDate.now(), 0, 0));
        //Si lo encontramos
        if (indice >= 0){
            return libros.get(indice);
        }
        //Si no lo encontramos
        return null;
    }    
    
}
