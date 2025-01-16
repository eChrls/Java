/*
 PARTE B

Dentro del mismo proyecto y del mismo paquete, crea otra clase llamada ParteBJOption, 
de forma que el programa realice lo mismo que el anterior, con la diferencia de que los datos se solicitan 
usando la clase JOptionPane. Los datos se mostrarán también usando la clase JOptionPane y se usará un text block 
para formatear el String que contiene los datos numéricos con tres decimales y toda la información con el resultado del ejercicio. 
 */
package daw;

import javax.swing.*;

public class ParteBJOption {
    public static void main(String[] args) {

    //Pedimos el número de contagiados con un JOption
    String contagiosStr = JOptionPane.showInputDialog("Introduce el número de contagios en la población las últimas dos semanas por favor");
    //usamos double en los habitantes para mejorar los resultados
    double habitantesEst = 75000.0;
    //convertimos contagios de String a Int
    int contagios = Integer.parseInt(contagiosStr);
    //calculamos la tasa en double
    double tasa = (contagios / habitantesEst) * 100000;
    //formato con texto block y 3 decimales
    String resultado = """
                       Resultados de Tasa de Contagios:
                       Número de habitantes: 75000
                       Número de contagios: %d
                       Tasa de contagios por cada 100mil habitantes: %.3f
                       """.formatted(contagios, tasa);

    JOptionPane.showMessageDialog (null, resultado);
}
}