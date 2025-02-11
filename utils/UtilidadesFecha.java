
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Indice:
 * 1. Calculo de edad
 * 2. Calculo de meses entre fechas
 * 3. Conversion de dias a unidades de tiempo
 * 4. Conversion de meses a años
 * 1. Validacion de formato
 * 2. Dia de la semana
 * 3. Conversion de string a fecha
 */
public class UtilidadesFecha {

    /**
     * Calcula la edad en años a partir de una fecha de nacimiento.
     *
     * @param fechaNacimiento fecha de nacimiento
     * @return edad en años
     */
    public static int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Calcula los meses transcurridos entre dos fechas.
     *
     * @param inicio fecha inicial
     * @param fin    fecha final
     * @return meses transcurridos
     */
    public static long calcularMesesEntre(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.MONTHS.between(inicio, fin);
    }

    /**
     * Convierte días a años, meses y días.
     *
     * @param dias número total de días
     * @return array con [años, meses, días]
     */
    public static int[] diasAUnidadesTiempo(int dias) {
        int años = dias / 365;
        int restoDias = dias % 365;
        int meses = restoDias / 30;
        int diasFinales = restoDias % 30;
        return new int[] { años, meses, diasFinales };
    }

    /**
     * Convierte meses a años y meses.
     *
     * @param meses número total de meses
     * @return array con [años, meses]
     */
    public static int[] mesesAAños(int meses) {
        int años = meses / 12;
        int mesesRestantes = meses % 12;
        return new int[] { años, mesesRestantes };
    }

    public class UtilidadesFecha {

        /**
         * Valida si una cadena tiene el formato de fecha especificado.
         *
         * @param fecha   cadena a validar
         * @param formato formato de fecha
         * @return true si la cadena tiene el formato correcto
         */
        public static boolean validarFormatoFecha(String fecha, String formato) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
                LocalDate.parse(fecha, formatter);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }

        /**
         * Obtiene el día de la semana de una fecha.
         *
         * @param fecha fecha para obtener el día de la semana
         * @return día de la semana
         */
        public static DayOfWeek obtenerDiaDeLaSemana(LocalDate fecha) {
            return fecha.getDayOfWeek();
        }

        /**
         * Convierte una cadena a un objeto LocalDate con el formato especificado.
         *
         * @param fecha   cadena a convertir
         * @param formato formato de la fecha
         * @return objeto LocalDate o null si la conversión falla
         */
        public static LocalDate convertirStringADate(String fecha, String formato) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
                return LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                return null;
            }
        }

        /**
         * Obtiene el nombre del mes de una fecha en un idioma específico.
         *
         * @param fecha  fecha para obtener el nombre del mes
         * @param locale idioma deseado
         * @return nombre del mes
         */
        public static String obtenerNombreDelMes(LocalDate fecha, Locale locale) {
            return fecha.getMonth().getDisplayName(java.time.format.TextStyle.FULL, locale);
        }
    }
}
