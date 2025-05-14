/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tareaa32;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

// Se implementa la interfaz
public class TareaA32 extends JPanel implements ActionListener {

    private JButton botonNombre, botonApellidos;
    private JTextArea texto;

    public TareaA32() {
        initComponents();
    }

    private void initComponents() {
        //botones
        botonNombre = new JButton("Nombre");
        botonApellidos = new JButton("Apellidos");
        
        //Area de texto
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.LIGHT_GRAY);
        
        
        this.setLayout(new FlowLayout());

        this.add(botonNombre);
        this.add(texto);
        this.add(botonApellidos);

// Se le indica al objeto boton que escuche eventos tipo click
// y se pasa como argumento una referencia de tipo ActionListener
// En este caso se pasa this que es el panel sobre el 
// que está el botón y que implementa la interfaz ActionListener
        botonNombre.addActionListener(this);
        botonApellidos.addActionListener(this);
    }

    @Override
    // Sobrescribimos el método de la interfaz
    public void actionPerformed(ActionEvent ae) {
 // Al pulsar "Nombre"
        if (ae.getSource() == botonNombre) {
            texto.setBackground(Color.WHITE);
            texto.setText("Carlos");    // Reemplaza "Carlos" por tu nombre real

        // Al pulsar "Apellidos"
        } else if (ae.getSource() == botonApellidos) {
            texto.setBackground(Color.white);
            texto.setText("Torralvo");     // Reemplaza "Pérez" por tus apellidos reales
        }
    }
    
        public static void main(String[] args) {
        // Ejecuta la creación de la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crea una ventana con título
            JFrame frame = new JFrame("Prueba TareaA32");
            // Establece que la aplicación termine al cerrar la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Añade una instancia del panel TareaA32 al contenido de la ventana
            frame.getContentPane().add(new TareaA32());
            // Ajusta el tamaño de la ventana al contenido
            frame.pack();
            // Centra la ventana en la pantalla
            frame.setLocationRelativeTo(null);
            // Hace visible la ventana
            frame.setVisible(true);
        });
    }
}

