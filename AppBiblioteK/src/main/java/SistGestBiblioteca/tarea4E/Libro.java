
package SistGestBiblioteca.tarea4E;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public class Libro {
    //Atributos de la clase libro
    private int ISBN; 
    private String titulo; 
    private Autor autor; 
    private LocalDate fechaEdicion; 
    private final int numPag; 
    private int numEdicion; 
    private Enum Editorial;
   
    
    //Constructor
    public Libro (int ISBN, String titulo, Autor autor, LocalDate fechaEdicion, Enum editorial, int numEdicion, int numPag){
        this.ISBN = ISBN;
        this.titulo=titulo;
        this.autor=autor;
        this.fechaEdicion=fechaEdicion;
        this.Editorial=editorial;
        this.numEdicion=numEdicion;
        this.numPag=numPag;
    }
    //Años que lleva publicado el libro
    public Long calcularAniosEdicion(){
        return ChronoUnit.YEARS.between(fechaEdicion, LocalDate.now());
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }

    public Enum getEditorial() {
        return Editorial;
    }

    public void setEditorial(Enum Editorial) {
        this.Editorial = Editorial;
    }

    public int getNumPag() {
        return numPag;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", fechaEdicion=" + fechaEdicion + ", numPag=" + numPag + ", numEdicion=" + numEdicion + ", Editorial=" + Editorial + '}';
    }



}
