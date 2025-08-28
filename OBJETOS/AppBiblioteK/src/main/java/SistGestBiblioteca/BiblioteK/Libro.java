
package SistGestBiblioteca.BiblioteK;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public class Libro implements Comparable<Libro> {
    //Atributos de la clase libro
    private int ISBN; 
    private String titulo; 
    private String autor; 
    private LocalDate fechaPublicacion; 
    private double precio; 
    private final int numPag; 
    
    //Constructor
    public Libro (int ISBN, String titulo, String autor, LocalDate fechaPublicacion, double precio, int numPag){
        this.ISBN = ISBN;
        this.titulo=titulo;
        this.autor=autor;
        this.fechaPublicacion=fechaPublicacion;
        this.precio=precio;
        this.numPag=numPag;
    }
    //Años que lleva publicado el libro
    public Long calcularAniosPublicado(){
        return ChronoUnit.YEARS.between(fechaPublicacion, LocalDate.now());
    }
    
    
    @Override
    public int hashCode(){
        return Objects.hash(ISBN);
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
        final Libro other = (Libro) obj;
        if (this.ISBN != other.ISBN) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
    //COMPARE TO PARA ORDENAR POR ID
    @Override
       public int compareTo(Libro otro) {
        return Integer.compare(this.ISBN, otro.ISBN);
    }


      // extra para comparar por titulo
    public class ComparadorPorTitulo implements Comparator<Libro> {

            @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getTitulo().compareTo(libro2.getTitulo());
        }
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", fechaPublicacion=" + fechaPublicacion + ", precio=" + precio + ", numPag=" + numPag + '}';
    }
    

    

}
