package proyectosobjetos.B;

import java.time.LocalDate;

/**
 * Representa a un pasajero en el sistema de reserva de vuelos.
 */
public class Pasajero {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String pasaporte;

    /**
     * Constructor por defecto.
     */
    public Pasajero() {
    }

    /**
     * Constructor con todos los atributos.
     * @param nombreCompleto Nombre completo del pasajero
     * @param fechaNacimiento Fecha de nacimiento del pasajero
     * @param pasaporte Número de pasaporte del pasajero
     */
    public Pasajero(String nombreCompleto, LocalDate fechaNacimiento, String pasaporte) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.pasaporte = pasaporte;
    }

    // Getters y setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
               "nombreCompleto='" + nombreCompleto + '\'' +
               ", fechaNacimiento=" + fechaNacimiento +
               ", pasaporte='" + pasaporte + '\'' +
               '}';
    }
}
