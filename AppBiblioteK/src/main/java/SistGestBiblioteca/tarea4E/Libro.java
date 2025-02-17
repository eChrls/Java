
package SistGestBiblioteca.tarea4E;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;
/*Crea una clase Libro que modele la información que se mantiene en una biblioteca sobre cada libro: 
Título, Autor (crea una clase básica con los atributos que consideres), ISBN (trece dígitos), Nº páginas, 
Nº edición, Editorial (crea un Enum) y fecha de edición (usa LocalDate). La clase debe proporcionar los 
siguientes métodos: constructor con parámetros, sin parámetros y copia, getters, setters, toString, 
equals y hashcode por ISBN.*/
public class Libro {
 
    private String titulo; 
    private Autor autor;
    private String isbn; 
    private int numPaginas; 
    private int numEdicion; 
    private Editorial editorial; 
    private LocalDate fechaEdicion; 
    
    //Constructor sin parámetros y valores por defecto
    //Lo utilizaremos en el método solicitarDatos() para llenarlo de los datos del usuario
    public Libro(){
        
        this.titulo="";
        this.autor= new Autor("","");
        this.isbn ="";
        this.numPaginas= 0;
        this.numEdicion=1;
        this.editorial=Editorial.RA_MA;
        this.fechaEdicion= LocalDate.now();
    }    
    //Constructor con parametros
       public Libro(String titulo, Autor autor, String isbn, int numPaginas, 
                int numEdicion, Editorial editorial, LocalDate fechaEdicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.numEdicion = numEdicion;
        this.editorial = editorial;
        this.fechaEdicion = fechaEdicion;
    }
       
        //Constructor copia
       //Lo utilizaré en el método copiar()
       public Libro (Libro otro){
           this.titulo= otro.titulo;
           this.autor=new Autor(otro.autor.getNombre(), otro.autor.getApellidos());
           this.isbn=otro.isbn;
           this.numPaginas=otro.numPaginas;
           this.numEdicion=otro.numEdicion;
           this.editorial=otro.editorial;
           this.fechaEdicion=otro.fechaEdicion;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo +
                ", autor=" + autor + ", isbn=" + isbn +
                ", numPaginas=" +  numPaginas + ", numEdicion=" + numEdicion +
                ", editorial=" + editorial + ", fechaEdicion=" + fechaEdicion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.isbn);
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
        final Libro other = (Libro) obj;
        return Objects.equals(this.isbn, other.isbn);
    }
       
       
       
       
}
