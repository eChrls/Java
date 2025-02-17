/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistGestBiblioteca.tarea4E;

import java.time.LocalDate;

public class ServicioLibro {
    
    public static Libro copiarLibro(Libro libro){
        
        Libro libroCopiado = new Libro (0, titulo, autor, LocalDate.MIN, editorial, 0, 0);
        libroCopiado = libro.clone();
        
        return libro; 
    }

   
    
    
    public static void solicitarDatos(){
        
    }
    
    
    public static Libro mostrarLibro (Libro libro){
        
        return libro; 
    }
    
}
