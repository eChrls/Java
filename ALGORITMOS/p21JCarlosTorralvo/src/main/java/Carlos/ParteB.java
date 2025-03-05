/*PARTE B
Modifica el ejercicio anterior para que la lectura de datos y la salida por pantalla 
usen diálogos JOptionPane y text block . Además, en esta parte, el número de horas 
anuales de los máster se debe poder introducir por teclado, también usando JOptionPane.*/
package Carlos;

import javax.swing.*;

public class ParteB {

    public static void main(String[] args) {
        //inicializamos las constantes
        final int horasProfesor = 150;
        final int horasMaster = 975;
        final double costeHrMaster = 32.47;
        //Pedimos los datos del número de másters con JOptionPane y transformamos a INT
        String numMasterStr = JOptionPane.showInputDialog("Introduce el número de másters para calcular información: ");
        int numMaster = Integer.parseInt(numMasterStr);
        //Repetimos los cálculos
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
        JOptionPane.showMessageDialog(null, resultado);
    }
}
