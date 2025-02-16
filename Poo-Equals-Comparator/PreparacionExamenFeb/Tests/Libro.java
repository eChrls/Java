
import java.time.LocalDate;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private double precio;
    private int numeroPaginas;

    public Libro(int id, String titulo, String autor, LocalDate fechaPublicacion, double precio, int numeroPaginas) {
        this.id= id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.numeroPaginas = numeroPaginas;
    }

    public interface Comparable<Libro> {
        int compareTo(Libro other);
    }

    public interface Comparator<Libro> {
        int compare(Libro o1, Libro o2);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Libro other = (Libro) obj;
        return this.id == other.id;
    }


    public int compareTo(Libro other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return id;

    }
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", precio=" + precio +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }

    

}
