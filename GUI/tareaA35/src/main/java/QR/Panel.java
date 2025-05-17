package QR;

import com.google.zxing.WriterException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/*
Hereda de JPanel.

Contiene todos los elementos visuales: campos de texto, botones, radios, etiquetas.

Captura el evento de clic en el botón y llama al método QR.generarQR(...).
*/
public class Panel extends JPanel {

    private JTextField textoQR; // Texto a codificar.
    private JTextField nombreFichero; //Nombre base del fichero de imagen.
    private JButton botonGenerar; //Lanza la acción.
    private JRadioButton radioPNG; //Permiten elegir el formato.
    private JRadioButton radioJPG;
    private ButtonGroup grupoRadios;

    public Panel() {
        this.setLayout(new GridLayout(6, 2));

        // Campo para introducir el texto que llevará el QR
        this.add(new JLabel("Introduce texto para el QR:"));
        textoQR = new JTextField(20);
        this.add(textoQR);

        // Campo para introducir el nombre del fichero (sin extensión)
        this.add(new JLabel("Nombre del fichero (sin extensión):"));
        nombreFichero = new JTextField(20);
        this.add(nombreFichero);

        // Etiqueta para indicar que se debe seleccionar la extensión
        this.add(new JLabel("Extensión del fichero:"));

        // Panel auxiliar para contener los radio buttons
        JPanel panelRadios = new JPanel();
        radioPNG = new JRadioButton("png", true); // Seleccionado por defecto
        radioJPG = new JRadioButton("jpg");
        grupoRadios = new ButtonGroup(); // Grupo que asegura selección única
        grupoRadios.add(radioPNG);
        grupoRadios.add(radioJPG);
        panelRadios.add(radioPNG);
        panelRadios.add(radioJPG);
        this.add(panelRadios);

        // Botón para generar QR
        botonGenerar = new JButton("Generar QR");
        this.add(botonGenerar);

        // Espacio para alinear la cuadrícula
        this.add(new JLabel(""));

        // Acción al pulsar el botón de generar
        botonGenerar.addActionListener((ActionEvent e) -> {
            String texto = textoQR.getText();
            String nombre = nombreFichero.getText();
            
            // Obtener la extensión seleccionada según el botón marcado
            String extension = radioPNG.isSelected() ? "png" : "jpg";
            
            if (texto.isBlank() || nombre.isBlank()) {
                JOptionPane.showMessageDialog(null, "Debes introducir texto y nombre de fichero");
                return;
            }
            
            String nombreCompleto = nombre + "." + extension;
                //Muestra una nueva ventana con el resultado (VentanaResultado).
            try {
                QR.generarQR(texto, nombreCompleto);
                new VentanaResultado(nombreCompleto);
            } catch (WriterException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al generar el QR");
            }
        });
    }
}
