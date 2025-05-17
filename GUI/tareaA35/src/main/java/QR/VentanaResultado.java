/*
Hereda de JFrame.

Simplemente abre una nueva ventana con un JLabel que muestra la imagen del QR generado (usando el nombre de archivo generado).
 */
package QR;

import javax.swing.*;
import java.awt.*;

public class VentanaResultado extends JFrame {

    public VentanaResultado(String nombreFichero) {//Crea una ventana nueva (JFrame) con título.
        this.setTitle("Resultado QR");
        this.setBounds(200, 200, 350, 350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Carga la imagen desde disco (ImageIcon) y la muestra en un JLabel.
        ImageIcon imagen = new ImageIcon(nombreFichero);
        JLabel etiqueta = new JLabel(imagen);
        this.add(etiqueta);

        this.setVisible(true);
    }
}
