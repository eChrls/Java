
package p41clinicaveterinaria;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
/**
 * Representa una cita en una clínica veterinaria.
 * Implementa Comparable para ordenar naturalmente por fecha y hora de la cita.
 */
public class Cita implements Comparable<Cita> {

    private static int contadorCitas = 1; // Para generar IDs únicos, es estático para mantener la cuenta entre todas las instancias

    private final int idCita; // Identificador único, final porque no cambia después de crear la cita
    private LocalDateTime fechaCreacionCita; // Cuándo se creó la cita
    private LocalDateTime fechaHoraCita; // Cuándo está programada la cita
    private String nombreUsuario; // Nombre del propietario de la mascota
    private String nombreMascota; // Nombre de la mascota
    private EstadoCita estadoCita; // Estado actual de la cita
    private int duracionMinutos; // Duración estimada en minutos
    private String motivoConsulta; // Motivo por el que se solicita la cita

    // Formato para mostrar fechas y horas
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    /****************************************************************************************************************************************************
     * Constructor sin parámetros. Crea una cita con valores por defecto. La
     * fecha de la cita se establece 15 días después de la fecha actual.
     */
    public Cita() {
        this.idCita = contadorCitas++;
        this.fechaCreacionCita = LocalDateTime.now();
        // La cita por defecto se programa para 15 días después a las 10:00
        LocalDateTime fechaPredeterminada = fechaCreacionCita.plus(15, ChronoUnit.DAYS)
                .withHour(10).withMinute(0).withSecond(0);
        // Si cae en miércoles, la movemos al jueves
        if (fechaPredeterminada.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            fechaPredeterminada = fechaPredeterminada.plus(1, ChronoUnit.DAYS);
        }

        this.fechaHoraCita = fechaPredeterminada;
        this.nombreUsuario = "Pendiente";
        this.nombreMascota = "Pendiente";
        this.estadoCita = EstadoCita.ACTIVA;
        this.duracionMinutos = 30; // Duración predeterminada
        this.motivoConsulta = "Pendiente de especificar";
    }

    /***************************************************************************************************************************************************
     * * Constructor parametrizado.Crea una cita con los datos proporcionados. Valida que la fecha de la cita sea válida.
     *
     * @param nombreUsuario Nombre del propietario
     * @param fechaHoraCita
     * @fechaHoraCita Fecha y hora programada para la cita
     * @param nombreMascota Nombre de la mascota
     * @param estadoCita Estado de la cita
     * @param duracionMinutos Duración estimada en minutos
     * @param motivoConsulta Motivo de la consulta
     * @throws IllegalArgumentException Si la fecha no es válida (miércoles o
     * anterior a la fecha actual)
     */
    public Cita(String nombreUsuario, LocalDateTime fechaHoraCita, String nombreMascota,
            EstadoCita estadoCita, int duracionMinutos, String motivoConsulta) {

        // Validación de parámetros
        if (fechaHoraCita == null) {
            throw new IllegalArgumentException("La fecha y hora de la cita no puede ser nula");
        }

        // Validación: No se pueden programar citas en miércoles
        if (fechaHoraCita.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            throw new IllegalArgumentException("Los miércoles la clínica está cerrada por descanso");
        }

        // Validación: No se pueden programar citas en fechas pasadas
        if (fechaHoraCita.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se pueden programar citas para fechas pasadas");
        }

        // Validación: Hora dentro del horario de atención (9:00 - 20:00)
        LocalTime horaConsulta = fechaHoraCita.toLocalTime();
        if (horaConsulta.isBefore(LocalTime.of(9, 0)) || horaConsulta.isAfter(LocalTime.of(19, 30))) {
            throw new IllegalArgumentException("Las citas deben estar entre las 9:00 y las 20:00");
        }

        // Validación de la duración (mínimo 15 minutos)
        if (duracionMinutos < 15) {
            throw new IllegalArgumentException("La duración mínima de una cita es de 15 minutos");
        }

        // Asignación de valores
        this.idCita = contadorCitas++;
        this.fechaCreacionCita = LocalDateTime.now();
        this.fechaHoraCita = fechaHoraCita;
        this.nombreUsuario = nombreUsuario;
        this.nombreMascota = nombreMascota;
        this.estadoCita = estadoCita;
        this.duracionMinutos = duracionMinutos;
        this.motivoConsulta = motivoConsulta;
    }
        
         // Métodos para cambiar el estado de la cita
    
    /**
     * Cambia el estado de la cita a ANULADA si la transición es válida
     * @return true si se pudo anular, false si no
     */
    public boolean anularCita() {
        if (estadoCita.esTransicionValida(EstadoCita.ANULADA)) {
            estadoCita = EstadoCita.ANULADA;
            return true;
        }
        return false;
    }

    /**
     * Cambia el estado de la cita a ACTIVA si la transición es válida
     * @return true si se pudo activar, false si no
     */
    public boolean activarCita() {
        if (estadoCita.esTransicionValida(EstadoCita.ACTIVA)) {
            estadoCita = EstadoCita.ACTIVA;
            return true;
        }
        return false;
    }

    /**
     * Cambia el estado de la cita a REALIZADA si la transición es válida
     * @return true si se pudo marcar como realizada, false si no
     */
    public boolean realizarCita() {
        if (estadoCita.esTransicionValida(EstadoCita.REALIZADA)) {
            estadoCita = EstadoCita.REALIZADA;
            return true;
        }
        return false;
    }

    /**
     * Cambia el estado de la cita a NOREALIZADA si la transición es válida
     * @return true si se pudo marcar como no realizada, false si no
     */
    public boolean noRealizarCita() {
        if (estadoCita.esTransicionValida(EstadoCita.NOREALIZADA)) {
            estadoCita = EstadoCita.NOREALIZADA;
            return true;
        }
        return false;
    }

    /**
     * Calcula la hora de finalización de la cita basándose en la duración
     * @return LocalDateTime con la fecha y hora de finalización
     */
    public LocalDateTime calcularHoraFinalizacion() {
        return fechaHoraCita.plusMinutes(duracionMinutos);
    }

    /**
     * Verifica si esta cita se solapa con otra
     * @param otraCita La cita con la que se compara
     * @return true si hay solapamiento, false si no
     */
    public boolean seSolapaCon(Cita otraCita) {
        // Si alguna de las citas está anulada, no hay solapamiento
        if (this.estadoCita == EstadoCita.ANULADA || otraCita.estadoCita == EstadoCita.ANULADA) {
            return false;
        }
        
        LocalDateTime inicioEsta = this.fechaHoraCita;
        LocalDateTime finEsta = this.calcularHoraFinalizacion();
        
        LocalDateTime inicioOtra = otraCita.fechaHoraCita;
        LocalDateTime finOtra = otraCita.calcularHoraFinalizacion();
        
        // Verificamos si hay solapamiento
        return (inicioEsta.isBefore(finOtra) && finEsta.isAfter(inicioOtra));
    }

    // Implementación de Comparable para ordenar naturalmente por fecha y hora de la cita
    /**
     * Compara esta cita con otra para ordenación.
     * El orden natural es por fecha y hora de la cita.
     * 
     * @param otraCita La cita con la que comparar
     * @return negativo si esta cita es anterior, positivo si es posterior, 0 si son iguales
     */
    @Override
    public int compareTo(Cita otraCita) {
        // Comparamos las fechas y horas directamente
        return this.fechaHoraCita.compareTo(otraCita.fechaHoraCita);
    }

    // Métodos equals y hashCode para comparación de igualdad basada en el ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cita other = (Cita) obj;
        return idCita == other.idCita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita);
    }

    // Getters y setters*******************************************************
    public int getIdCita() {
        return idCita;
    }

    public LocalDateTime getFechaCreacionCita() {
        return fechaCreacionCita;
    }

    public void setFechaCreacionCita(LocalDateTime fechaCreacionCita) {
        this.fechaCreacionCita = fechaCreacionCita;
    }

    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
        // Validamos que no sea miércoles ni fecha pasada
        if (fechaHoraCita.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            throw new IllegalArgumentException("Los miércoles la clínica está cerrada por descanso");
        }
        
        if (fechaHoraCita.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se pueden programar citas para fechas pasadas");
        }
        
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos < 15) {
            throw new IllegalArgumentException("La duración mínima de una cita es de 15 minutos");
        }
        this.duracionMinutos = duracionMinutos;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cita #").append(idCita).append("\n");
        sb.append("Fecha y hora: ").append(fechaHoraCita.format(FORMATO_FECHA_HORA)).append("\n");
        sb.append("Propietario: ").append(nombreUsuario).append("\n");
        sb.append("Mascota: ").append(nombreMascota).append("\n");
        sb.append("Estado: ").append(estadoCita.name()).append(" - ").append(estadoCita.getDescripcionCita()).append("\n");
        sb.append("Duración: ").append(duracionMinutos).append(" minutos\n");
        sb.append("Motivo: ").append(motivoConsulta).append("\n");
        sb.append("Creada el: ").append(fechaCreacionCita.format(FORMATO_FECHA_HORA));
        return sb.toString();
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
