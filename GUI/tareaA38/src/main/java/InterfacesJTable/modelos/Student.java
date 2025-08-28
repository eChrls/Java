package InterfacesJTable.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Clase que representa a un estudiante con su información básica
 */
public class Student {

    private String id;
    private String nombre;
    private String localidad;
    private String unidad;
    private String fechaNacimiento;
    private String sexo;
    private String paisNacimiento;

    /**
     * Constructor con todos los campos
     */
    public Student(String id, String nombre, String localidad, String unidad, String fechaNacimiento, String sexo, String paisNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.unidad = unidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.paisNacimiento = paisNacimiento;
    }

    /**
     * Constructor vacío
     */
    public Student() {
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.localidad);
        hash = 31 * hash + Objects.hashCode(this.unidad);
        hash = 31 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 31 * hash + Objects.hashCode(this.sexo);
        hash = 31 * hash + Objects.hashCode(this.paisNacimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", unidad=" + unidad + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", paisNacimiento=" + paisNacimiento + '}';
    }
}
