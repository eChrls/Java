/*
Hereda de JFrame.

Configura la ventana principal: tamaño, título, cierre, visibilidad, etc.

Añade un objeto de la clase Panel como contenido de la ventana.
 */
package QR;


import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        this.setTitle("Generador QR");
        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panel());
        this.setVisible(true);
    }
}
