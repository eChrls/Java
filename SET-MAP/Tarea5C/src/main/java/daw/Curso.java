
package daw;

import java.util.Objects;

public class Curso {
    private String nombre;
    private int horas;
    
    // Constructor para crear un nuevo curso con nombre y número de horas
    public Curso(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }
    
    // Getters y setters para acceder y modificar los atributos privados
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getHoras() {
        return horas;
    }
    
    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    // Sobreescribimos el método equals para comparar cursos por su nombre
    // Esto es importante para evitar duplicados en las estructuras de datos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Si es el mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false;  // Si es null o de otra clase
        Curso curso = (Curso) o;  // Convertimos el objeto a Curso
        return Objects.equals(nombre, curso.nombre);  // Comparamos solo por nombre
    }
    
    // Sobreescribimos hashCode para que sea coherente con equals
    // Esto es necesario para el correcto funcionamiento de HashSet y HashMap
    @Override
    public int hashCode() {
        return Objects.hash(nombre);  // Generamos el código hash solo basado en el nombre
    }
    
    // Método toString para mostrar la información del curso de forma legible
    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", horas=" + horas +
                '}';
    }
}
