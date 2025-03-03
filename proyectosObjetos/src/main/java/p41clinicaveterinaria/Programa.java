package p41clinicaveterinaria;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase principal que contiene el menú interactivo del sistema de gestión de citas.
 */
public class Programa {

    private static GestorCitas gestor = new GestorCitas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargar algunas citas de ejemplo
        cargarCitasEjemplo();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        crearCitaPorDefecto();
                        break;
                    case 2:
                        crearCitaParametrizada();
                        break;
                    case 3:
                        modificarCita();
                        break;
                    case 4:
                        buscarCitas();
                        break;
                    case 5:
                        mostrarListadosOrdenados();
                        break;
                    case 6:
                        mostrarEstadisticas();
                        break;
                    case 7:
                        gestionarEstadosCita();
                        break;
                    case 8:
                        exportarListado();
                        break;
                    case 9:
                        salir = true;
                        System.out.println("¡Gracias por usar el sistema de gestión de citas!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
            }
            if (!salir) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n==== SISTEMA DE GESTIÓN DE CITAS VETERINARIAS ====");
        System.out.println("1. Crear cita por defecto");
        System.out.println("2. Solicitar datos y guardar cita");
        System.out.println("3. Modificar datos de una cita existente");
        System.out.println("4. Buscar citas por diferentes criterios");
        System.out.println("5. Mostrar listados ordenados");
        System.out.println("6. Mostrar estadísticas básicas");
        System.out.println("7. Gestionar cancelaciones y cambios de estado");
        System.out.println("8. Exportar listado de citas a texto");
        System.out.println("9. Salir del programa");
        System.out.println("==================================================");
    }

    /**
     * Carga citas de ejemplo para probar el funcionamiento del sistema.
     */
    private static void cargarCitasEjemplo() {
        try {
            // Se crean citas de ejemplo usando el constructor parametrizado.
            Cita cita1 = new Cita(
                    "Ana López",
                    LocalDateTime.now().plusDays(2).withHour(10).withMinute(0),
                    "Bobby",
                    EstadoCita.ACTIVA,
                    30,
                    "Consulta general");
            Cita cita2 = new Cita(
                    "Carlos García",
                    LocalDateTime.now().plusDays(3).withHour(11).withMinute(0),
                    "Max",
                    EstadoCita.ACTIVA,
                    30,
                    "Vacunación");
            gestor.agregarCita(cita1);
            gestor.agregarCita(cita2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al cargar citas de ejemplo: " + e.getMessage());
        }
    }

    /**
     * Opción 1: Crea una cita con valores por defecto.
     */
    private static void crearCitaPorDefecto() {
        Cita nuevaCita = new Cita();
        if (gestor.agregarCita(nuevaCita)) {
            System.out.println("Cita creada con éxito:");
            System.out.println(nuevaCita);
        } else {
            System.out.println("Error: La cita se solapa con otra existente.");
        }
    }

    /**
     * Opción 2: Solicita datos al usuario y crea una cita parametrizada.
     */
    private static void crearCitaParametrizada() {
        try {
            Cita nuevaCita = UtilidadesCita.solicitarDatosCita(scanner);
            if (gestor.agregarCita(nuevaCita)) {
                System.out.println("Cita creada con éxito:");
                System.out.println(nuevaCita);
            } else {
                System.out.println("Error: La cita se solapa con otra existente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear la cita: " + e.getMessage());
        }
    }

    /**
     * Opción 3: Modifica los datos de una cita ya existente.
     */
    private static void modificarCita() {
        System.out.println("== MODIFICAR CITA ==");
        List<Cita> citas = gestor.obtenerTodasLasCitas();
        if (citas.isEmpty()) {
            System.out.println("No hay citas para modificar.");
            return;
        }
        System.out.println("Citas disponibles:");
        for (Cita cita : citas) {
            System.out.println(cita.getIdCita() + " - " + cita.getNombreUsuario() +
                    " (" + cita.getNombreMascota() + ") - " +
                    UtilidadesCita.formatearFechaHora(cita.getFechaHoraCita(), 1));
        }
        System.out.print("Ingrese el ID de la cita a modificar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese los nuevos datos. Deje en blanco (o 0 en el caso de duración) si no desea cambiar el valor.");
        System.out.print("Nuevo nombre del propietario: ");
        String nuevoNombre = scanner.nextLine();
        if (nuevoNombre.isEmpty()) nuevoNombre = null;

        System.out.print("Nuevo nombre de la mascota: ");
        String nuevoMascota = scanner.nextLine();
        if (nuevoMascota.isEmpty()) nuevoMascota = null;

        LocalDateTime nuevaFechaHora = null;
        System.out.print("Nueva fecha (dd-MM-yyyy) (o deje en blanco): ");
        String fechaStr = scanner.nextLine();
        if (!fechaStr.isEmpty()) {
            System.out.print("Nueva hora (HH:mm): ");
            String horaStr = scanner.nextLine();
            try {
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
                LocalDate fecha = LocalDate.parse(fechaStr, formatoFecha);
                LocalTime hora = LocalTime.parse(horaStr, formatoHora);
                nuevaFechaHora = LocalDateTime.of(fecha, hora);
            } catch (Exception e) {
                System.out.println("Formato de fecha/hora incorrecto. Se conservará el valor original.");
                nuevaFechaHora = null;
            }
        }
        System.out.print("Nueva duración en minutos (mínimo 15 o 0 para no cambiar): ");
        int nuevaDuracion;
        try {
            nuevaDuracion = Integer.parseInt(scanner.nextLine());
            if (nuevaDuracion > 0 && nuevaDuracion < 15) {
                System.out.println("La duración mínima es de 15 minutos. Se conservará el valor original.");
                nuevaDuracion = 0;
            }
        } catch (NumberFormatException e) {
            nuevaDuracion = 0;
        }
        System.out.print("Nuevo motivo de la consulta (o deje en blanco): ");
        String nuevoMotivo = scanner.nextLine();
        if (nuevoMotivo.isEmpty()) nuevoMotivo = null;

        boolean modificado = gestor.modificarCita(id, nuevaFechaHora, nuevoNombre, nuevoMascota, nuevaDuracion, nuevoMotivo);
        if (modificado) {
            System.out.println("Cita modificada con éxito.");
        } else {
            System.out.println("Error al modificar la cita. Verifique que los datos sean correctos y que no se solapen con otra cita.");
        }
    }

    /**
     * Opción 4: Busca citas según distintos criterios.
     */
    private static void buscarCitas() {
        System.out.println("== BUSCAR CITAS ==");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre del propietario");
        System.out.println("3. Buscar por fecha (dd-MM-yyyy)");
        System.out.print("Seleccione un criterio de búsqueda: ");
        int criterio = Integer.parseInt(scanner.nextLine());
        switch (criterio) {
            case 1:
                System.out.print("Ingrese el ID de la cita: ");
                int id = Integer.parseInt(scanner.nextLine());
                Cita cita = gestor.buscarCitaPorId(id);
                if (cita != null) {
                    System.out.println("Cita encontrada:");
                    System.out.println(cita);
                } else {
                    System.out.println("No se encontró una cita con ese ID.");
                }
                break;
            case 2:
                System.out.print("Ingrese el nombre del propietario: ");
                String nombre = scanner.nextLine();
                List<Cita> citasPorPropietario = gestor.filtrarPorPropietario(nombre);
                if (citasPorPropietario.isEmpty()) {
                    System.out.println("No se encontraron citas para el propietario dado.");
                } else {
                    System.out.println("Citas encontradas:");
                    for (Cita c : citasPorPropietario) {
                        System.out.println(c);
                    }
                }
                break;
            case 3:
                System.out.print("Ingrese la fecha (dd-MM-yyyy): ");
                String fechaInput = scanner.nextLine();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fecha = LocalDate.parse(fechaInput, formatter);
                    List<Cita> citasPorFecha = gestor.filtrarPorFecha(fecha);
                    if (citasPorFecha.isEmpty()) {
                        System.out.println("No se encontraron citas para esa fecha.");
                    } else {
                        System.out.println("Citas encontradas:");
                        for (Cita c : citasPorFecha) {
                            System.out.println(c);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Formato de fecha incorrecto.");
                }
                break;
            default:
                System.out.println("Criterio de búsqueda no válido.");
        }
    }

    /**
     * Opción 5: Muestra listados de citas ordenados según diversos criterios.
     */
    private static void mostrarListadosOrdenados() {
        System.out.println("== LISTADOS ORDENADOS ==");
        System.out.println("1. Ordenar por fecha y hora");
        System.out.println("2. Ordenar por nombre del propietario");
        System.out.println("3. Ordenar por nombre de la mascota");
        System.out.println("4. Ordenar por duración");
        System.out.println("5. Ordenar por estado");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        List<Cita> citasOrdenadas = null;
        switch (opcion) {
            case 1:
                citasOrdenadas = gestor.obtenerCitasOrdenadasPorFechaHora();
                break;
            case 2:
                citasOrdenadas = gestor.obtenerCitasOrdenadas(new ComparadoresCita.ComparadorPorNombrePropietario());
                break;
            case 3:
                citasOrdenadas = gestor.obtenerCitasOrdenadas(new ComparadoresCita.ComparadorPorNombreMascota());
                break;
            case 4:
                citasOrdenadas = gestor.obtenerCitasOrdenadas(new ComparadoresCita.ComparadorPorDuracion());
                break;
            case 5:
                citasOrdenadas = gestor.obtenerCitasOrdenadas(new ComparadoresCita.ComparadorPorEstado());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        System.out.println("Listado de citas ordenadas:");
        for (Cita c : citasOrdenadas) {
            System.out.println(c);
            System.out.println("--------------------------------");
        }
    }

    /**
     * Opción 6: Muestra estadísticas básicas de las citas.
     */
    private static void mostrarEstadisticas() {
        System.out.println("== ESTADÍSTICAS ==");
        Map<EstadoCita, Integer> stats = gestor.obtenerEstadisticasPorEstado();
        System.out.println("Citas por estado:");
        for (Map.Entry<EstadoCita, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey().name() + ": " + entry.getValue());
        }
    }

    /**
     * Opción 7: Gestiona cambios de estado de una cita: cancelación, realizada o no realizada.
     */
    private static void gestionarEstadosCita() {
        System.out.println("== GESTIONAR CANCELACIONES Y CAMBIOS DE ESTADO ==");
        System.out.println("1. Cancelar una cita (cambiar a ANULADA)");
        System.out.println("2. Marcar cita como REALIZADA");
        System.out.println("3. Marcar cita como NOREALIZADA");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el ID de la cita: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean resultado = false;
        switch (opcion) {
            case 1:
                resultado = gestor.cambiarEstadoCita(id, EstadoCita.ANULADA);
                break;
            case 2:
                resultado = gestor.cambiarEstadoCita(id, EstadoCita.REALIZADA);
                break;
            case 3:
                resultado = gestor.cambiarEstadoCita(id, EstadoCita.NOREALIZADA);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        if (resultado) {
            System.out.println("Estado de la cita actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar el estado de la cita.");
        }
    }

    /**
     * Opción 8: Exporta el listado de citas a un archivo de texto.
     */
    private static void exportarListado() {
        String listado = gestor.exportarListadoCitas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("listado_citas.txt"))) {
            writer.write(listado);
            System.out.println("Listado exportado a 'listado_citas.txt'.");
        } catch (IOException e) {
            System.out.println("Error al exportar el listado: " + e.getMessage());
        }
    }
}
