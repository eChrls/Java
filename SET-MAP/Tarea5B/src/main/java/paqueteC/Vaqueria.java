package paqueteC;

public class Vaqueria {
    private String nombre;
    private String ubicacion;
    private int numeroVacas;
    
    // Constructor
    public Vaqueria(String nombre, String ubicacion, int numeroVacas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numeroVacas = numeroVacas;
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int getNumeroVacas() {
        return numeroVacas;
    }
    
    public void setNumeroVacas(int numeroVacas) {
        this.numeroVacas = numeroVacas;
    }
    
    @Override
    public String toString() {
        return "Vaqueria{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", numeroVacas=" + numeroVacas +
                '}';
    }
}