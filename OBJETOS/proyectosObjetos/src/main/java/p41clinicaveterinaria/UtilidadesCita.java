
package p41clinicaveterinaria;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Clase de utilidades para operaciones relacionadas con citas.
 * Contiene métodos estáticos para validación, formato y solicitud de datos.
 */
public class UtilidadesCita {
    
    // Constantes para los formatos de fecha y hora
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private static final DateTimeFormatter FORMATO_FECHA_HORA_SEGUNDOS = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    /**
     * Solicita al usuario los datos para crear una nueva cita.
     * @param scanner Scanner para leer la entrada del usuario
     * @return Una nueva instancia de Cita con los datos proporcionados
     */
    public static Cita solicitarDatosCita(Scanner scanner) {
        System.out.println("=== CREAR NUEVA CITA ===");
        
        // Solicitar nombre del propietario
        System.out.print("Nombre del propietario: ");
        String nombreUsuario = scanner.nextLine();
        
        // Solicitar nombre de la mascota
        System.out.print("Nombre de la mascota: ");
        String nombreMascota = scanner.nextLine();
        
        // Solicitar fecha y hora
        LocalDateTime fechaHoraCita = null;
        boolean fechaValida = false;
        
        while (!fechaValida) {
            try {
                System.out.print("Fecha (dd-MM-yyyy): ");
                String fechaStr = scanner.nextLine();
                
                System.out.print("Hora (HH:mm): ");
                String horaStr = scanner.nextLine();
                
                LocalDate fecha = LocalDate.parse(fechaStr, FORMATO_FECHA);
                LocalTime hora = LocalTime.parse(horaStr, FORMATO_HORA);
                
                fechaHoraCita = LocalDateTime.of(fecha, hora);
                
                // Validar la fecha y hora
                validarFechaHoraCita(fechaHoraCita);
                fechaValida = true;
                
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha u hora incorrecto. Inténtelo de nuevo.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Inténtelo de nuevo.");
            }
        }
        
        // Solicitar duración
        int duracion = 30; // Valor por defecto
        boolean duracionValida = false;
        
        while (!duracionValida) {
            try {
                System.out.print("Duración en minutos (mínimo 15): ");
                duracion = Integer.parseInt(scanner.nextLine());
                
                if (duracion < 15) {
                    System.out.println("Error: La duración mínima es de 15 minutos.");
                } else {
                    duracionValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        
        // Solicitar motivo de la consulta
        System.out.print("Motivo de la consulta: ");
        String motivo = scanner.nextLine();
        
        // Crear y devolver la nueva cita
        return new Cita(nombreUsuario, fechaHoraCita, nombreMascota, EstadoCita.ACTIVA, duracion, motivo);
    }
    
    /**
     * Valida si una fecha y hora son válidas para una cita.
     * @param fechaHora La fecha y hora a validar
     * @throws IllegalArgumentException Si la fecha/hora no cumple con las restricciones
     */
    public static void validarFechaHoraCita(LocalDateTime fechaHora) throws IllegalArgumentException {
        // Verificar que no sea miércoles
        if (fechaHora.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            throw new IllegalArgumentException("Los miércoles la clínica está cerrada por descanso.");
        }
        
        // Verificar que no sea una fecha pasada
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se pueden programar citas para fechas pasadas.");
        }
        
        // Verificar que esté dentro del horario de atención (9:00 - 20:00)
        LocalTime hora = fechaHora.toLocalTime();
        if (hora.isBefore(LocalTime.of(9, 0)) || hora.isAfter(LocalTime.of(19, 30))) {
            throw new IllegalArgumentException("Las citas deben estar entre las 9:00 y las 20:00.");
        }
    }
    
    /**
     * Verifica si una hora está dentro del horario de atención.
     * @param hora La hora a verificar
     * @return true si la hora está dentro del horario, false en caso contrario
     */
    public static boolean esHorarioValido(LocalTime hora) {
        return !(hora.isBefore(LocalTime.of(9, 0)) || hora.isAfter(LocalTime.of(19, 30)));
    }
    
    /**
     * Formatea una fecha y hora según el formato especificado.
     * @param fechaHora La fecha y hora a formatear
     * @param tipoFormato El tipo de formato deseado (1: corto, 2: largo, 3: solo fecha, 4: solo hora)
     * @return La fecha formateada como String
     */
    public static String formatearFechaHora(LocalDateTime fechaHora, int tipoFormato) {
        switch (tipoFormato) {
            case 1: // Formato corto (dd-MM-yyyy HH:mm)
                return fechaHora.format(FORMATO_FECHA_HORA);
            case 2: // Formato largo (dd-MM-yyyy HH:mm:ss)
                return fechaHora.format(FORMATO_FECHA_HORA_SEGUNDOS);
            case 3: // Solo fecha (dd-MM-yyyy)
                return fechaHora.format(FORMATO_FECHA);
            case 4: // Solo hora (HH:mm)
                return fechaHora.format(FORMATO_HORA);
            default:
                return fechaHora.format(FORMATO_FECHA_HORA);
        }
    }
    
    /**
     * Calcula el tiempo libre entre dos citas consecutivas en minutos.
     * @param citaAnterior La primera cita
     * @param citaPosterior La segunda cita
     * @return El tiempo libre en minutos, o -1 si las citas se solapan
     */
    public static long calcularTiempoEntreCitas(Cita citaAnterior, Cita citaPosterior) {
        // Verificar que la citaPosterior sea posterior a citaAnterior
        if (!citaAnterior.getFechaHoraCita().isBefore(citaPosterior.getFechaHoraCita())) {
            throw new IllegalArgumentException("La segunda cita debe ser posterior a la primera");
        }
        
        LocalDateTime finCitaAnterior = citaAnterior.calcularHoraFinalizacion();
        LocalDateTime inicioCitaPosterior = citaPosterior.getFechaHoraCita();
        
        // Si hay solapamiento, devolvemos -1
        if (finCitaAnterior.isAfter(inicioCitaPosterior)) {
            return -1;
        }
        
        // Calculamos la diferencia en minutos
        return java.time.Duration.between(finCitaAnterior, inicioCitaPosterior).toMinutes();
    }
}