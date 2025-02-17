package SistGestBiblioteca;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
     
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro(1, "Don Quijote", "Cervantes",  LocalDate.of(1605, 1, 1), 29.99, 863);
        Libro libro2 = new Libro(2, "El Principito", "Saint-Exupéry", LocalDate.of(1943, 4, 6), 15.99, 96);
        Libro libro3 = new Libro(3, "1984", "Orwell", LocalDate.of(1949, 6, 8), 19.99, 328);
        
        biblioteca.AgregarLibros(libro3);
        biblioteca.AgregarLibros(libro2);
        biblioteca.AgregarLibros(libro1);
        
        System.out.println("Libros disponibles:");
        biblioteca.MostrarLibros();
        System.out.println("*************************************************************************************************");
        System.out.println("Libros ordenados por precio:");
        biblioteca.ordenarPorPrecio();
        biblioteca.MostrarLibros();
        System.out.println("*************************************************************************************************");
        System.out.println("Buscamos libro con id = 2");
        int idBuscado = 2; 
        Libro libroEncontrado = biblioteca.buscarPorId(idBuscado);
        System.out.println("Buscando libro con ID " + idBuscado + ":");
        if(libroEncontrado != null){
            System.out.println("Libro encontrado : " + libroEncontrado);
            System.out.println("Antigüedad: " + libroEncontrado.calcularAniosPublicado() + " años");
        }else{
            System.out.println("Libro no encontrado");
        }
        
    }
}
    

