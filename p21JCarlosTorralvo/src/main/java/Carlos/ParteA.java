/*PARTE A
En esta parte la lectura se realiza usando Scanner y la salida con consola usando 
text block. Se debe mostrar toda la información: número de horas por máster, 
número de másteres a impartir, profesores necesarios, coste de la hora  
y coste total de un máster y coste de todos los másteres, limitando la salida 
a dos decimales.*/
package Carlos;

import java.util.*;

public class ParteA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Inicializamos constantes
        final int horasProfesor = 150;
        final int horasMaster = 975;
        final double costeHrMaster = 32.47;
        System.out.println("Introduce el número de másters que necesita impartir");
        //Escaneamos el número de masters
        int numMaster = sc.nextInt();
        //Calculamos número de profesores necesarios
        int profNecesarios = (int) Math.ceil((double) (numMaster * horasMaster) / horasProfesor);
        //Calculamos coste en total y por separado
        double costeMasterTotal = numMaster * horasMaster * costeHrMaster;
        double costeUnSoloMaster = horasMaster * costeHrMaster;
        //formato block para los datos y en decimales usamos 2. 
        String resultado = """
                           Información sobre los másters introducidos: 
                           Nº de horas por máster = %d
                           Nº de másters a impartir = %d
                           Nº de profesores que impartirán clase = %d
                           Coste por hora de máster = 32.47 €
                           Coste total de un máster = %.2f€
                           Coste total de todos los másters = %.2f€
                           """.formatted(horasMaster, numMaster, profNecesarios, costeUnSoloMaster, costeMasterTotal);
        System.out.println(resultado);
    }
}
