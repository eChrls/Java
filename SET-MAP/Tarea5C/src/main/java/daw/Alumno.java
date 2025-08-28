
package daw;

import java.util.Objects;

public class Alumno {

    private String nombre;
    private String nif;
    
  // Constructor para crear un nuevo alumno con nombre y nif
    public Alumno(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    
    // Sobreescribimos el método equals para comparar alumnos por su NIF
    // Esto es importante para evitar duplicados en las estructuras de datos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Si es el mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false;  // Si es null o de otra clase
        Alumno alumno = (Alumno) o;  // Convertimos el objeto a Alumno
        return Objects.equals(nif, alumno.nif);  // Comparamos solo por NIF
    }
    
    // Sobreescribimos hashCode para que sea coherente con equals
    // Esto es necesario para el correcto funcionamiento de HashSet y HashMap
    @Override
    public int hashCode() {
        return Objects.hash(nif);  // Generamos el código hash solo basado en el NIF
    }
    



}