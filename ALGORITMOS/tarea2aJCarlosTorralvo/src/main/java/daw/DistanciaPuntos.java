/*En una nueva clase dentro del mismo paquete, llamada DistanciaPuntos, realiza un programa que calcule 
la distancia entre dos puntos en un plano cartesiano. Para ello solicita los datos de tipo int (x,y) de cada punto y 
realiza el cálculos de la distancia entre ambos puntos con la ayuda del teorema de Pitágoras. Usando variables booleanas, 
muestra el resultado de evaluar si todas las dimensiones introducidas por el usuario están entre -10 y 10. 
La lectura y escritura de información se hace usando JOption.*/
package daw;

import javax.swing.JOptionPane;

public class DistanciaPuntos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub		
        // Coordenadas del primer punto
        int x1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la coordenada x del primer punto:"));
        int y1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la coordenada y del primer punto:"));

        // Coordenadas del segundo punto
        int x2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la coordenada x del segundo punto:"));
        int y2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la coordenada y del segundo punto:"));

        // Teorema de Pitágoras  d=√((x_2-x_1)²+(y_2-y_1)²)
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Evaluar si las dimensiones están entre -10 y 10
        boolean todasEntreMenos10y10 = (x1 >= -10 && x1 <= 10) && (y1 >= -10 && y1 <= 10)
                && (x2 >= -10 && x2 <= 10) && (y2 >= -10 && y2 <= 10);
        // Mostrar resultados
        JOptionPane.showMessageDialog(null, "La distancia entre los puntos es: " + distancia);
        JOptionPane.showMessageDialog(null, "Todas las dimensiones están entre -10 y 10: " + todasEntreMenos10y10);
    }
}
