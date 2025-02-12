public class Libro {
    
    private int id; 
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private double precio; 
    private int numeroPaginas;

    public Libro(int id, String titulo, String autor, LocalDate fechaPublicacion, double precio, int numeroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.numeroPaginas = numeroPaginas;
    }

public interface Comparable<T> {
    int compareTo(T other);
}

public interface Comparator<T> {
    int compare(T o1, T o2);
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
    public boolean equals(Object obj){
        if (this == obj)
        return true;
        if (obj == null || getClass() != obj.getClass())
        return false;

        Libro other = (Libro) obj;
        return this.id == other.id;
    }
 
}
