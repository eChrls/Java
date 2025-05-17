
package CalculadoraGUI;


import javax.swing.JFrame;

/**
 * Clase principal que crea el JFrame y añade el PanelPrincipal.
 */
public class Calculadora {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CalculadoraDAW");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PanelPrincipal());
        frame.pack();          
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
